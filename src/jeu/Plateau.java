package jeu;

public class Plateau {
	
	private Case[] cases;
	private De de1;
	private De de2;
	
	public Plateau()
	{
		cases = new Case[30];
		for (int i = 0;i<30;i++)
		{
			cases[i] = new Case(i);
		}
		de1 = new De(6);
		de2 = new De(6);
	}
	public Case getCase(int numero)
	{
		return cases[numero];
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
