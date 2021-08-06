package utfpr.javaii;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Race {

	private String nameThread;
	private int racePosition;
	private int racePoints;
	private int champPoints;
	private static Runnable r1;
	private static Runnable r2;
	private static Runnable r3;
	private static Runnable r4;
	private static Runnable r5;
	private static Runnable r6;
	private static Runnable r7;
	private static Runnable r8;
	private static Runnable r9;
	private static Runnable r10;
	static int numRace = 0;
	static int position = 0;
	static int totalR1 = 0;
	private static ExecutorService executor;
	static Object monitor = new Object();

	public int getRacePoints() {
		return racePoints;
	}

	public void setRacePoints(int pontCampeonato) {
		this.racePoints = pontCampeonato;
	}

	public Race(String nomeThread, int pontuacao, int pontCampeonato, int totalPontos) {

		this.nameThread = nomeThread;
		this.racePosition = pontuacao;
		this.racePoints = pontCampeonato;
		this.champPoints = totalPontos;
	}

	public Race() {

	}

	public int getChampPoints() {
		return champPoints;
	}

	public void setChampPoints(int totalPontos) {
		this.champPoints = totalPontos;
	}

	public String getNameThread() {
		return nameThread;
	}

	public void setNameThread(String nomeThread) {
		this.nameThread = nomeThread;
	}

	public int getRacePosition() {
		return racePosition;
	}

	public void setRacePosition(int pontuacao) {
		this.racePosition = pontuacao;
	}

	@Override
	public String toString() {
		return nameThread + " Pontos no Campeonato ->" + champPoints;
	}

	public String toStringNew() {
		return racePosition + " Posição -> " + nameThread + " -> Pontos na Corrida ->" + +racePoints
				+ " -> Pontos acumulados ->" + champPoints;
	}

	public static void main(String[] args) {

		Race ct = new Race();
		Race ct1 = new Race();
		Race ct2 = new Race();
		Race ct3 = new Race();
		Race ct4 = new Race();
		Race ct5 = new Race();
		Race ct6 = new Race();
		Race ct7 = new Race();
		Race ct8 = new Race();
		Race ct9 = new Race();

		List<Race> listFinal = new ArrayList<>();

		listFinal.add(ct);
		listFinal.add(ct1);
		listFinal.add(ct2);
		listFinal.add(ct3);
		listFinal.add(ct4);
		listFinal.add(ct5);
		listFinal.add(ct6);
		listFinal.add(ct7);
		listFinal.add(ct8);
		listFinal.add(ct9);

		Race race = new Race();

		Runnable restartRace = () -> {

			numRace++;
			position = 0;

			Collections.sort(listFinal, race.new compPosition());

			System.out.println("\n\nRanking: Race " + numRace);

			for (Race cliente : listFinal) {

				System.out.println(cliente.toStringNew());

			}

			listFinal.get(0);

			if (numRace < 10) {

				restart();
			}

			if (numRace == 10) {

				Collections.sort(listFinal, race.new compChampPoints());

				System.out.println("\n------------Ranking final do Campeonato------------\n");

				for (Race cliente : listFinal) {

					System.out.println(cliente.toString());

				}

				System.out.println("\n !!!Campeão!!! " + listFinal.get(0).getNameThread() + " :Pontos "
						+ listFinal.get(0).getChampPoints());

				finalizador();

			}
		};

		CyclicBarrier cyclicBarrier = new CyclicBarrier(10, restartRace);

		executor = Executors.newFixedThreadPool(10);

		r1 = () -> {
			synchronized (monitor) {
				position++;
				Thread.currentThread().setName("Competidor#1");
				String nome = Thread.currentThread().getName();
				ct.setNameThread(nome);
				ct.setRacePosition(position);
				ct.setRacePoints(11 - position);
				ct.setChampPoints(ct.getChampPoints() + ct.getRacePoints());

			}
			await(cyclicBarrier);
		};

		r2 = () -> {
			synchronized (monitor) {
				position++;
				Thread.currentThread().setName("Competidor#2");
				String nome = Thread.currentThread().getName();
				ct1.setNameThread(nome);
				ct1.setRacePosition(position);
				ct1.setRacePoints(11 - position);
				ct1.setChampPoints(ct1.getChampPoints() + ct1.getRacePoints());

			}
			await(cyclicBarrier);
		};

		r3 = () -> {
			synchronized (monitor) {
				position++;
				Thread.currentThread().setName("Competidor#3");
				String nome = Thread.currentThread().getName();
				ct2.setNameThread(nome);
				ct2.setRacePosition(position);
				ct2.setRacePoints(11 - position);
				ct2.setChampPoints(ct2.getChampPoints() + ct2.getRacePoints());
			}
			await(cyclicBarrier);
		};

		r4 = () -> {
			synchronized (monitor) {
				position++;
				Thread.currentThread().setName("Competidor#4");
				String nome = Thread.currentThread().getName();
				ct3.setNameThread(nome);
				ct3.setRacePosition(position);
				ct3.setRacePoints(11 - position);
				ct3.setChampPoints(ct3.getChampPoints() + ct3.getRacePoints());
			}
			await(cyclicBarrier);
		};

		r5 = () -> {
			synchronized (monitor) {
				position++;
				Thread.currentThread().setName("Competidor#5");
				String nome = Thread.currentThread().getName();
				ct4.setNameThread(nome);
				ct4.setRacePosition(position);
				ct4.setRacePoints(11 - position);
				ct4.setChampPoints(ct4.getChampPoints() + ct4.getRacePoints());
			}
			await(cyclicBarrier);
		};

		r6 = () -> {
			synchronized (monitor) {
				position++;
				Thread.currentThread().setName("Competidor#6");
				String nome = Thread.currentThread().getName();
				ct5.setNameThread(nome);
				ct5.setRacePosition(position);
				ct5.setRacePoints(11 - position);
				ct5.setChampPoints(ct5.getChampPoints() + ct5.getRacePoints());
			}
			await(cyclicBarrier);
		};

		r7 = () -> {
			synchronized (monitor) {
				position++;
				Thread.currentThread().setName("Competidor#7");
				String nome = Thread.currentThread().getName();
				ct6.setNameThread(nome);
				ct6.setRacePosition(position);
				ct6.setRacePoints(11 - position);
				ct6.setChampPoints(ct6.getChampPoints() + ct6.getRacePoints());
			}
			await(cyclicBarrier);
		};

		r8 = () -> {
			synchronized (monitor) {
				position++;
				Thread.currentThread().setName("Competidor#8");
				String nome = Thread.currentThread().getName();
				ct7.setNameThread(nome);
				ct7.setRacePosition(position);
				ct7.setRacePoints(11 - position);
				ct7.setChampPoints(ct7.getChampPoints() + ct7.getRacePoints());
			}
			await(cyclicBarrier);
		};

		r9 = () -> {
			synchronized (monitor) {
				position++;
				Thread.currentThread().setName("Competidor#9");
				String nome = Thread.currentThread().getName();
				ct8.setNameThread(nome);
				ct8.setRacePosition(position);
				ct8.setRacePoints(11 - position);
				ct8.setChampPoints(ct8.getChampPoints() + ct8.getRacePoints());
			}
			await(cyclicBarrier);
		};

		r10 = () -> {
			synchronized (monitor) {
				position++;
				Thread.currentThread().setName("Competidor#10");
				String nome = Thread.currentThread().getName();
				ct9.setNameThread(nome);
				ct9.setRacePosition(position);
				ct9.setRacePoints(11 - position);
				ct9.setChampPoints(ct9.getChampPoints() + ct9.getRacePoints());
			}
			await(cyclicBarrier);
		};

		restart();
	}// main

	private static void await(CyclicBarrier cyclicBarrier) {
		try {
			cyclicBarrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
	}

	private static void restart() {
		sleep();
		executor.submit(r1);
		executor.submit(r2);
		executor.submit(r3);
		executor.submit(r4);
		executor.submit(r5);
		executor.submit(r6);
		executor.submit(r7);
		executor.submit(r8);
		executor.submit(r9);
		executor.submit(r10);

	}

	private static void sleep() {
		try {

			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void finalizador() {
		System.out.println("-----------------Fim do campeonato-----------------");
		executor.shutdown();
	}

	public class compChampPoints implements Comparator<Race> {

		@Override
		public int compare(Race o1, Race o2) {

			if (o1.getChampPoints() < (o2.getChampPoints())) {
				return 1;
			}

			return -1;
		}

	}

	public class compPosition implements Comparator<Race> {

		@Override
		public int compare(Race o1, Race o2) {
			if (o1.getRacePosition() > (o2.getRacePosition())) {
				return 1;
			}

			return -1;
		}

	}

}
