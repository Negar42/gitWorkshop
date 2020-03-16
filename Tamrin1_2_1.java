import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class Tamrin1_2_1 {
	public static void main(String[] args) {
		String player,team;
		int numberOfTeams,numberOfPlayers;
		Scanner scanner=new Scanner(System.in);
		HashMap<String,String> teamsAndPlayers=new HashMap<String,String>();
		TreeSet<String> guilty=new TreeSet<String>();
		numberOfPlayers=scanner.nextInt();
		numberOfTeams=scanner.nextInt();
		scanner.nextLine();
		for(int i=0;i<numberOfPlayers;i++) {
			teamsAndPlayers.put(scanner.nextLine(), "0");
		}
		for(int i=0;i<numberOfTeams;i++) {
			team=scanner.nextLine();
			numberOfPlayers=scanner.nextInt();
			scanner.nextLine();
			for(int j=0;j<numberOfPlayers;j++) {
				player=scanner.nextLine();
				if(teamsAndPlayers.containsKey(player)) {
					if(teamsAndPlayers.get(player).equals("0")) {
						teamsAndPlayers.put(player, team);
					}
					else {
						guilty.add(team);
						guilty.add(teamsAndPlayers.get(player));
					}
				}
				else {
					guilty.add(team);
				}
			}
		}
		for(String str:guilty) {
		System.out.println(str);
		}
		
		}
	}