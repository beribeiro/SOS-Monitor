package br.com.listavip;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.listavip.model.Analysts;
import br.com.listavip.model.Requests;
import br.com.listavip.service.RequestsService;


@Controller
public class RepositoryController {
	@Autowired
	private RequestsService requestsService;

	@Autowired
	private Analysts analysts;

	
	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("dashboard")
	public String requestList(Model model) {
		
		List <Requests> requests = requestsService.findAllOpenRequestsOrderByDate();
		model.addAttribute("requests", requests);
		
		for (Requests requests2 : requests) {
			Calendar calendarDate = Calendar.getInstance();
			calendarDate.setTime(requests2.getData());
			String calculateHour = requestsService.HourCalculate(calendarDate); 
			requests2.setHoraCalc(calculateHour);
			model.addAttribute("calculateHour", calculateHour);
		}
		return "dashboard";
	}
}
