
public class TennisGame2 implements TennisGame
{
    private static final int _MatchPoint = 4;
	private static final int _Forty = 3;
	private static final int _Thirty = 2;
	private static final int _Fifteen = 1;
	private static final int _Love = 0;
	public int player1Points = 0;
    public int player2Points = 0;

    public String convertToLiteralPlayer1Points = "";
    public String convertToLiteralPlayer2Points = "";

    public TennisGame2(String player1Name, String player2Name) {
    }

    public String getScore(){
        String score = "";
        int player1Points2 = player1Points;
		int player2Points2 = player2Points;
		score = tiedAndNotDeuce(score, player1Points2, player2Points2);
        score = winningPlayer(score, player1Points2, player2Points2);
        score = winingPlayerIsNotDeuce(score, player1Points2, player2Points2);
        score = playerAdvantage(score, player1Points2, player2Points2);
        score = winForPlayer1orPlayer2(score, player1Points2, player2Points2);
        return score;
    }

	private String tiedAndNotDeuce(String score, int player1Points2, int player2Points2) {
		if (player1Points2 == player2Points2 && player1Points2 < _MatchPoint)
        {
            if (player1Points2==_Love)
                score = "Love";
            if (player1Points2==_Fifteen)
                score = "Fifteen";
            if (player1Points2==_Thirty)
                score = "Thirty";
            score += "-All";
        }
        if (player1Points2==player2Points2 && player1Points2>=_Forty)
            score = "Deuce";
		return score;
	}

	private String winningPlayer(String score, int player1Points2, int player2Points2) {
		if (player1Points2 > _Love && player2Points2==_Love)
        {
            if (player1Points2==_Fifteen)
                convertToLiteralPlayer1Points = "Fifteen";
            if (player1Points2==_Thirty)
                convertToLiteralPlayer1Points = "Thirty";
            if (player1Points2==_Forty)
                convertToLiteralPlayer1Points = "Forty";
            convertToLiteralPlayer2Points = "Love";
            score = convertToLiteralPlayer1Points + "-" + convertToLiteralPlayer2Points;
        }
        if (player2Points2 > _Love && player1Points2==_Love)
        {
            if (player2Points2==_Fifteen)
                convertToLiteralPlayer2Points = "Fifteen";
            if (player2Points2==_Thirty)
                convertToLiteralPlayer2Points = "Thirty";
            if (player2Points2==_Forty)
                convertToLiteralPlayer2Points = "Forty";
            convertToLiteralPlayer1Points = "Love";
            score = convertToLiteralPlayer1Points + "-" + convertToLiteralPlayer2Points;
        }
		return score;
	}

	private String winingPlayerIsNotDeuce(String score, int player1Points2, int player2Points2) {
		if (player1Points2>player2Points2 && player1Points2 < _MatchPoint)
        {
            score = thirty_forty_or_fifteen_for_player1(player1Points2, player2Points2);
        }
        if (player2Points2>player1Points2 && player2Points2 < _MatchPoint)
        {
            score = thirty_forty_or_fifteen_for_player2(player1Points2, player2Points2);
        }
		return score;
	}

	private String thirty_forty_or_fifteen_for_player1(int player1Points2, int player2Points2) {
		String score;
		if (player1Points2==_Thirty)
		    convertToLiteralPlayer1Points="Thirty";
		if (player1Points2==3)
		    convertToLiteralPlayer1Points="Forty";
		if (player2Points2==_Fifteen)
		    convertToLiteralPlayer2Points="Fifteen";
		if (player2Points2==_Thirty)
		    convertToLiteralPlayer2Points="Thirty";
		score = convertToLiteralPlayer1Points + "-" + convertToLiteralPlayer2Points;
		return score;
	}

	private String thirty_forty_or_fifteen_for_player2(int player1Points2, int player2Points2) {
		String score;
		if (player2Points2==_Thirty)
		    convertToLiteralPlayer2Points="Thirty";
		if (player2Points2==_Forty)
		    convertToLiteralPlayer2Points="Forty";
		if (player1Points2==_Fifteen)
		    convertToLiteralPlayer1Points="Fifteen";
		if (player1Points2==_Thirty)
		    convertToLiteralPlayer1Points="Thirty";
		score = convertToLiteralPlayer1Points + "-" + convertToLiteralPlayer2Points;
		return score;
	}

	private String winForPlayer1orPlayer2(String score, int player1Points2, int player2Points2) {
		if (player1Points2>=_MatchPoint && player2Points2>=_Love && (player1Points2-player2Points2)>=_Thirty)
        {
            score = "Win for player1";
        }
        if (player2Points2>=_MatchPoint && player1Points2>=_Love && (player2Points2-player1Points2)>=_Thirty)
        {
            score = "Win for player2";
        }
		return score;
	}

	private String playerAdvantage(String score, int player1Points, int player2Points2) {
		if (player1Points > player2Points2 && player2Points2 >= _Forty)
        {
        	
            score = "Advantage player1";
        }

        if (player2Points2 > player1Points && player1Points >= _Forty)
        {
            score = "Advantage player2";
        }
		return score;
	}

    public void setPlayer1Score(int number){

        for (int i = 0; i < number; i++)
        {
            player1Scores();
        }
    }

    public void setPlayer2Score(int number){

        for (int i = 0; i < number; i++)
        {
            player2Scores();
        }
    }

    public void player1Scores(){
        player1Points++;
    }

    public void player2Scores(){
        player2Points++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            player1Scores();
        else
            player2Scores();
    }
}