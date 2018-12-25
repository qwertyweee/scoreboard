package databaseLab.scoreboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class homeController {
	
	
	@Autowired 
	private JudgeRepository judgeRepository;
	@Autowired 
	private TeamRepository teamRepository;
	
	int temp2=0;
	
	@GetMapping("/")
	public String home() {	

		return "home";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("judge", new Judge());
		return "loginPage";
	}
	
	@PostMapping("/login")
	public String loginSubmit(@ModelAttribute Judge judge,@ModelAttribute Team team, Model model) {
		
		model.addAttribute("team", new Team());
		
		int temp = judge.getId(); 
		temp2=temp;
		String tempPass = judge.getPassword();
		
		judge = judgeRepository.findById(temp); 		

		
		model.addAttribute("judges" , judgeRepository.findById(temp));
		model.addAttribute("teams", teamRepository.findAll());
		
		try {
			judge.getName();
			if(tempPass.equals(String.valueOf(judge.getPassword())))
				return "judgePage";
			else
				return "errorLogin";
		} catch (Exception e) {
			return "errorLogin";
		}
				
	}
	
	@GetMapping("/register")
	public String register(Model model) {				
		
		model.addAttribute("judge", new Judge());
		return "registerPage";
	}
	
	@PostMapping("/register")
	public String registerSave(@ModelAttribute Judge judge) {				
						
		judgeRepository.save(judge);
		
		return "home";
	}
	
	@GetMapping("/scoreboard")
	public String printScoreboard(Model model) {						
		
		model.addAttribute("teams", teamRepository.findAll());
		
		return "scoreboardPage";
	}
	
	@GetMapping("/regteam")
	public String registerTeam(Model model) {								
		model.addAttribute("team", new Team());		
		return "registerTeamPage";
	}
	
	@PostMapping("/regteam")
	public String registerTeamSave(@ModelAttribute Team team, Model model) {								
		teamRepository.save(team);	
		
		model.addAttribute("judges" , judgeRepository.findById(temp2));
		model.addAttribute("teams", teamRepository.findAll());
		return "judgePage";
	}
	
	@PostMapping("/update")
	public String updateScore(@ModelAttribute Team team, Model model) {								
		
		Team teamTrue = new Team();
		int temp = team.getTeamId();				
		String tempQuestion,tempComment;
		
		teamTrue = teamRepository.findById(temp);
		
		tempQuestion = team.getQuestion();
		tempComment = team.getComment();
		
		teamTrue.setQuestion(tempQuestion);
		
		teamTrue.updateResult(tempComment, tempQuestion);
		
		teamRepository.save(teamTrue);
		
		model.addAttribute("judges" , judgeRepository.findById(temp2));
		model.addAttribute("teams", teamRepository.findAll());
		return "judgePage";
	}
	
	@GetMapping("/delteam")
	public String deleteTeam(Model model) {	
		
		model.addAttribute("team", new Team());
		
		model.addAttribute("teams", teamRepository.findAll());

		return "deleteTeamPage";
	}
	
	@PostMapping("/delteam")
	public String deleteTeam(@ModelAttribute Team team,Model model) {	
		
		teamRepository.deleteById(team.getTeamId());
		model.addAttribute("teams", teamRepository.findAll());
		return "deleteTeamPage";
	}
	
	@GetMapping("/all")
	public @ResponseBody String printAllUser() {	
		
	//User a = Repository.findBymatricNum(2);

		return "";
	}
}
