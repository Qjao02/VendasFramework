package FrameworkMIF;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Menu extends Action implements Method {
	
	private String title;
	private String optionText;
	private String errorText;
	private List<Action> actionList;	
	
	/**
	 * @param title
	 * @param optionText
	 * @param errorText
	 * @param actions
	 */
	public Menu(String title, String optionText, String errorText, List<Action> actions) {
		super();
		this.title = title;
		this.optionText = optionText;
		this.errorText = errorText;
		this.actionList  = actions;
		actionList.add(0, new Action("Sair", new MethodExit()));
		super.setMethod(this);
		super.setName(title);
	}
	
	public Menu() { 
		title = "Menu";
		optionText = "Selecione a opção: ";
		errorText = "Um erro ocorreu!";
		actionList = new ArrayList<Action>();
		actionList.add(new Action("Sair", new MethodExit()));
		super.setMethod(this);
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOptionText() {
		return optionText;
	}

	public void setOptionText(String optionText) {
		this.optionText = optionText;
	}

	public String getErrorText() {
		return errorText;
	}

	public void setErrorText(String errorText) {
		this.errorText = errorText;
	}

	public List<Action> getActionList() {
		return actionList;
	}

	public void setActionList(List<Action> actionList) {
		this.actionList = actionList;
	}

	public void ShowError() {
		System.out.println(errorText);
	}

	@Override
	public void run() {
		int opt = 1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (opt > 0) {
			System.out.println(title);
			for (int i=0; i<actionList.size(); i++) {
				System.out.println(i + " - " + actionList.get(i).getName());
			}
			System.out.println(optionText);
			try {
				opt = Integer.parseInt(br.readLine());
				actionList.get(opt).getMethod().run();
			} catch (IOException e) {
				ShowError();
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Opção inválida.");
			}
		}
		actionList.get(0).getMethod().run();
	}
}
