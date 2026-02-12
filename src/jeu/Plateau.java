package jeu;

public class Plateau {
	
	private int[] cases = new int[30];
	private De de1;
	private De de2;
	
	public Plateau()
	{
		for (int i = 0;i<30;i++)
		{
			cases[i] = i+1;
		}
		de1 = new De(6);
		de2 = new De(6);
	}

	public int lancerDes()
	{
		return (de1.lancerDe() + de2.lancerDe());
	}
	
	public int getNombreCases()
	{
		return cases.length;
	}
	
}
