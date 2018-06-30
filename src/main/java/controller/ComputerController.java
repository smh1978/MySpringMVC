package controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.Computer;

@Controller
@RequestMapping("/computer")
public class ComputerController {

	private Map<Integer, Computer> computerList = new HashMap<Integer, Computer>();
	
	public ComputerController(){
		computerList.put(1, new Computer(1, "lenovo电脑", 5000));
		computerList.put(2, new Computer(2, "dell电脑", 2000));
		computerList.put(3, new Computer(3, "hp电脑", 4000));
		computerList.put(4, new Computer(4, "axus电脑", 3000));
		System.out.println("computerList的长度：" + computerList.size());
	}
	
	@RequestMapping(path="/list", method = RequestMethod.GET)
	public String computerList(Model model) {
		
		model.addAttribute("computerList", computerList);		
		return "computerList";
	}
	
	@RequestMapping(path="/delete/{id}", method = RequestMethod.GET)
	public String computerDelete(@PathVariable Integer id) {
		computerList.remove(id);
		System.out.println("delete 后，computerList的长度：" + computerList.size());
		for (Integer in : computerList.keySet()) {
			//map.keySet()返回的是所有key的值
			Computer computer = computerList.get(in);//得到每个key多对用value的值
			System.out.println(in + "     " + computer.toString());
		}
		return "redirect:/computer/list";
	}
	
	@RequestMapping(path="/add", method = RequestMethod.GET)
	public String goAddComputerView() {
		return "computerAdd";
	}
	
	@RequestMapping(path="/add", method = RequestMethod.POST)
	public String computerAdd(@RequestParam String tradeMark, @RequestParam String price) {
		System.out.println(tradeMark + " " + price);
		System.out.println("增加前computerList的长度：" + computerList.size());
	
		Object keys[] = computerList.keySet().toArray();
		Arrays.sort(keys);
		System.out.println("最大key:" + keys[keys.length-1]);
		int MaxKey = (int) keys[keys.length-1];
		Computer computer = new Computer(computerList.size()+1,tradeMark, Integer.parseInt(price));
		computerList.put(MaxKey+1, computer);
		System.out.println("增加后computerList的长度：" + computerList.size());
		
		return "redirect:/computer/list";
	}
	
	@RequestMapping(path="/update/{id}", method = RequestMethod.GET)
	public String goUpdateComputerView(@PathVariable Integer id, Model model) {
		System.out.println("computer param from computerList : " + id);
		model.addAttribute("computer", computerList.get(id));
		return "computerUpdate";
	}
	
	@RequestMapping(path="/update/{id}", method = RequestMethod.POST)
	public String computerUpdate(@PathVariable Integer id, 
			                     @RequestParam String tradeMark,
			                     @RequestParam String price) {
		System.out.println(id + " " + tradeMark + " " + price);
		computerList.put(id, new Computer(id, tradeMark, Integer.parseInt(price)));
		return "redirect:/computer/list";
	}
	
}
