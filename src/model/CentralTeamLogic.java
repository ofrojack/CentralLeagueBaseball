package model;

import java.util.ArrayList;

import dao.CentralLeagueStandingsDAO;

public class CentralTeamLogic {
	public ArrayList<CentralTeam> execute() {
		CentralLeagueStandingsDAO dao =
				new CentralLeagueStandingsDAO();
		ArrayList<CentralTeam> ct;
		try {
			ct = dao.getTeam();
			return ct;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
}