package com.mowitnow.lawn;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.mowitnow.constants.Orientation;

/**
 * Création de la pelouse et initialisation de l'environnement
 * 
 * @author sylva
 *
 */
public class Lawn {

	/**
	 * Dimensions maximales de la grille
	 */
	private int xMax;
	private int yMax;

	/**
	 * Nombre de tondeuses
	 */
	private int nbMowers;

	/**
	 * Initialisation de l'environnement à partir du fichier de paramétrage
	 * 
	 * @param list
	 */
	private void init(List<String> list) {
		String[] tabDim = list.get(0).split(" ");
		setxMax(Integer.parseInt(tabDim[0]));
		setyMax(Integer.parseInt(tabDim[1]));
		setNbMowers((list.size() - 1) / 2);
		
	}

	/**
	 * Construction de la liste des tondeuses et déplacement des tondeuses dans la grille
	 * 
	 * @param list
	 */
	private void moveMowers(List<String> list) {
		List<String> listCoord = new ArrayList<String>();
		List<String> listInstr = new ArrayList<String>();
		for (int i = 1; i <= list.size() - 1; i++) {
			if (i % 2 == 0)
				listInstr.add(list.get(i));
			else
				listCoord.add(list.get(i));
		}
		for (int j = 0; j < getNbMowers(); j++) {
			String[] tabCoordOrigin = listCoord.get(j).split(" ");
			Coordinate origin = new Coordinate(Integer.parseInt(tabCoordOrigin[0]), Integer.parseInt(tabCoordOrigin[1]),
					Orientation.valueOf(tabCoordOrigin[2]));
			Mower mower = new Mower(j + 1, origin);
			mower.move(listInstr.get(j),this);
		}
	}

	/**
	 * Lancement du programme
	 */
	public void startMowers() {
		try {
			InputStream ips = getClass().getResourceAsStream("/mowitnow.txt");
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			List<String> list = new ArrayList<String>();
			while ((ligne = br.readLine()) != null) {
				list.add(ligne);
			}
			br.close();
			init(list);
			moveMowers(list);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public int getxMax() {
		return xMax;
	}

	public void setxMax(int xMax) {
		this.xMax = xMax;
	}

	public int getyMax() {
		return yMax;
	}

	public void setyMax(int yMax) {
		this.yMax = yMax;
	}

	public int getNbMowers() {
		return nbMowers;
	}

	public void setNbMowers(int nbMowers) {
		this.nbMowers = nbMowers;
	}
}
