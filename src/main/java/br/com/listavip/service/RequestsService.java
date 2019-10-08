package br.com.listavip.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.listavip.model.Analysts;
import br.com.listavip.model.Requests;
import br.com.listavip.repository.RequestRepository;

@Service
public class RequestsService {

	@Autowired
	private RequestRepository requestRepository;
	
	

	public List<Requests> findAllOpenRequestsOrderByDate() {
		List <Analysts> analysts = new ArrayList<Analysts>();
//		analysts.add(new Analysts("Bruno Esperancin Ribeiro",true));
//		analysts.add(new Analysts("Fabio Antonio Gomes",true));
//		analysts.add(new Analysts("Amanda Piccoli Franco Pinto",true));
//		analysts.add(new Analysts("Taina de Almeida Brito",true));
		analysts.add(new Analysts("FILA N2 - AppSupport - ADM/HR/Finance",true));
		analysts.add(new Analysts("FILA N2 - AppSupport - Commercial",true));
		
		List<String> analystsName = new ArrayList<String>();
		for (Analysts analysts2 : analysts) {
			if (analysts2.isAtivo()){
				analystsName.add(analysts2.getNome());
			}
		}
		List<Requests> requests = requestRepository.findAllOpenRequestsOrderByDate(analystsName);
		return requests;
	}
	
	public String HourCalculate(Calendar initialDate) {
		
        Calendar finalDate = Calendar.getInstance();
        
        List<Long> utilHoursList = new ArrayList<Long>();
        utilHoursList.add(8L);
        utilHoursList.add(9L);
        utilHoursList.add(10L);
        utilHoursList.add(11L);
        utilHoursList.add(13L);
        utilHoursList.add(14L);
        utilHoursList.add(15L);
        utilHoursList.add(16L);
        
        List<Long> utilDayList = new ArrayList<Long>();
        utilDayList.add(Long.valueOf(Calendar.MONDAY));
        utilDayList.add(Long.valueOf(Calendar.TUESDAY));
        utilDayList.add(Long.valueOf(Calendar.WEDNESDAY));
        utilDayList.add(Long.valueOf(Calendar.THURSDAY));
        utilDayList.add(Long.valueOf(Calendar.FRIDAY));
        
        long differenceHour = 0L;
        Calendar i = initialDate;
        i.add(Calendar.HOUR_OF_DAY, 1);
        while (i.before(finalDate)) {
        	if (utilDayList.contains(Long.valueOf(i.get(Calendar.DAY_OF_WEEK)))) {
        		if (utilHoursList.contains(Long.valueOf(i.get(Calendar.HOUR_OF_DAY)))) {
        			differenceHour++;
        		}
        		i.add(Calendar.HOUR_OF_DAY, 1);
        	} else {
        		i.add(Calendar.DAY_OF_MONTH, 1);
        	}
        }
        
        long initialMinute = initialDate.get(Calendar.MINUTE);
        long finalMinute = finalDate.get(Calendar.MINUTE);
        if (initialMinute > finalMinute){
        	finalMinute = finalMinute + 60;
        	differenceHour--;
        }
        long differenceMinutes = finalMinute - initialMinute;
        
        long initialSecond = initialDate.get(Calendar.SECOND);
        long finalSecond = finalDate.get(Calendar.SECOND);
        if (initialSecond > finalSecond){
        	finalSecond = finalSecond + 60;
        	differenceMinutes--;
        }
        long differenceSeconds = finalSecond - initialSecond;
        
        long timeInSeconds = (differenceHour * 3600) + (differenceMinutes * 60) + differenceSeconds;
        long SLA = 28800L;
        long timetoSLA = 0L;
        
        timetoSLA = SLA - timeInSeconds;
        
        
        String displayTime = String.format("%02d:%02d:%02d", differenceHour, differenceMinutes, differenceSeconds);
        
		return displayTime;
	}
}
