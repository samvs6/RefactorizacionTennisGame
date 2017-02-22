
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
		if (tiedScore(player1Points2, player2Points2) && isNotMatchPoint(player1Points2))
        {
            if (isLove(player1Points2))
                score = "Love";
            if (player1Points2==_Fifteen)
                score = "Fifteen";
            if (player1Points2==_Thirty)
                score = "Thirty";
            score += "-All";
        }
        if (tiedScore(player1Points2, player2Points2) && higherOrEqualsForty(player1Points2))
            score = "Deuce";
		return score;
	}

	private boolean higherOrEqualsForty(int player1Points2) {
		return player1Points2>=_Forty;
	}

	private boolean isNotMatchPoint(int player1Points2) {
		return player1Points2 < _MatchPoint;
	}

	private boolean tiedScore(int player1Points2, int player2Points2) {
		return player1Points2 == player2Points2;
	}

	private String winningPlayer(String score, int player1Points2, int player2Points2) {
		if (moreThanLove(player1Points2) && isLove(player2Points2))
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
        if (moreThanLove(player2Points2) && isLove(player1Points2))
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

	private boolean isLove(int player2Points2) {
		return player2Points2==_Love;
	}

	private boolean moreThanLove(int player1Points2) {
		return player1Points2 > _Love;
	}

	private String winingPlayerIsNotDeuce(String score, int player1Points2, int player2Points2) {
		if (firstPlayerIsWinning(player1Points2, player2Points2) && isNotMatchPoint(player1Points2))
        {
            score = thirty_forty_or_fifteen_for_player1(player1Points2, player2Points2);
        }
        if (firstPlayerIsWinning(player2Points2, player1Points2) && isNotMatchPoint(player2Points2))
        {
            score = thirty_forty_or_fifteen_for_player2(player1Points2, player2Points2);
        }
		return score;
	}

	private boolean firstPlayerIsWinning(int player1Points2, int player2Points2) {
		return player1Points2>player2Points2;
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
		if (higherOrEqualsMatchPoint(player1Points2) && moreOrEqualsLove(player2Points2) && differenceISEqualsOrHigherThanTrirty(player1Points2, player2Points2))
        {
            score = "Win for player1";
        }
        if (higherOrEqualsMatchPoint(player2Points2) && moreOrEqualsLove(player1Points2) && differenceISEqualsOrHigherThanTrirty(player2Points2, player1Points2))
        {
            score = "Win for player2";
        }
		return score;
	}

	private boolean moreOrEqualsLove(int player2Points2) {
		return player2Points2>=_Love;
	}

	private boolean differenceISEqualsOrHigherThanTrirty(int player1Points2, int player2Points2) {
		return (player1Points2-player2Points2)>=_Thirty;
	}

	private boolean higherOrEqualsMatchPoint(int player1Points2) {
		return player1Points2>=_MatchPoint;
	}

	private String playerAdvantage(String score, int player1Points, int player2Points2) {
		if (firstPlayerIsWinning(player1Points, player2Points2) && higherOrEqualsForty(player2Points2))
        {
        	
            score = "Advantage player1";
        }

        if (firstPlayerIsWinning(player2Points2, player1Points) && higherOrEqualsForty(player1Points))
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