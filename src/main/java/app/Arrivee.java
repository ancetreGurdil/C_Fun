package app;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class Arrivee {
	private static final long Invalid =-1;
	private static int numeroSortie = 0;
	private int numeroArrivee;


	public int getNumeroArrivee() {
		return numeroArrivee;
	}

	private char choixSport;

	public char getChoixSport() {
		return choixSport;
	}

	private long horaireArrivee;
	private long horaireDepart;

	private Complexe complexe;

	public Arrivee(final Complexe complexe, final char choixSport) {
		this.horaireArrivee = Calendar.getInstance().getTimeInMillis();
		this.choixSport = choixSport;
		this.complexe = complexe;
		this.horaireDepart = Invalid;
		this.numeroArrivee = complexe.generateNumeroArrivee();
	}

	public String afficheBillet() {
		final String MSGNOM = "Complexe ";
		final String MSGNUM = "Billet d'entrée n° : ";
		final String MSGDATE = "Date : ";
		final String MSGHEURE = "Heure : ";

		String leBillet;
		leBillet = MSGNOM + this.getComplexe().getNomComplexe() + "\t";
		leBillet += MSGNUM + this.numeroArrivee + "\n";

		Calendar leCal = Calendar.getInstance();
		leCal.setTimeInMillis(this.horaireArrivee);
		Date laDate = leCal.getTime();
		SimpleDateFormat leJour = new SimpleDateFormat("dd/MM/yyyy");
		leBillet += MSGDATE + leJour.format(laDate) + "\n";
		SimpleDateFormat lHeure = new SimpleDateFormat("HH:mm");
		leBillet += MSGHEURE + lHeure.format(laDate) + "\n";

		return leBillet;
	}

	public String afficheTicket() {
		final String MSGNOM = "Complexe ";
		final String MSGNUM = "Ticket de sortie n° : ";
		final String MSGDATE = "Date : ";
		final String MSGHEURE = "Heure : ";
		final String MSGCOUT = "Montant : ";

		String leTicket;

		leTicket = MSGNOM + this.getComplexe().getNomComplexe() + "\t";
		leTicket += MSGNUM + ++Arrivee.numeroSortie + "\n";


		Calendar heureDeDepart = Calendar.getInstance();
		heureDeDepart.setTimeInMillis(horaireDepart);

		Date laDate = heureDeDepart.getTime();

		long millis = Instant.now().toEpochMilli();


		SimpleDateFormat leJour = new SimpleDateFormat("dd/MM/yyyy");
		leTicket += MSGDATE + leJour.format(millis) + "\n";
		SimpleDateFormat lHeure = new SimpleDateFormat("HH:mm");
		leTicket += MSGHEURE + lHeure.format(millis) + "\n";
		leTicket += MSGCOUT + this.getMontant() + " €\n";

		return leTicket;
	}

	public double getMontant() {
		double cout = 0;

		if (horaireDepart != Invalid) {
			long nbQuart = getCompterQuartHeure();

			if (nbQuart <= 1){
				cout = 0;
			}else if (nbQuart <= 2){
				cout =0.5;
			}else if (nbQuart <= 4){
				cout = 1;
			}else {
				cout = 1+(nbQuart - 4)*0.5;
			}

		}
		return cout;
	}

	public long getDureeEnMilliseconde(){
		if (horaireArrivee == Invalid || horaireDepart == Invalid){
			return Invalid;
		}
		return horaireDepart - horaireArrivee;
	}

	public long getDureeEnMinute(){
		if (horaireArrivee == Invalid || horaireDepart == Invalid){
			return Invalid;
		}
		return getDureeEnMilliseconde()/60_000;
	}

	public long getCompterQuartHeure(){
		if (horaireArrivee == Invalid || horaireDepart == Invalid){
			return 0;
		}
		long NbQuart = getDureeEnMinute()/15;
		if (NbQuart * 15 != getDureeEnMinute()){
			NbQuart++;
		}
		return NbQuart;
	}


	public Complexe getComplexe() {
		return this.complexe;
	}

	public void setNumeroArrivee(int numero) {
		numeroArrivee = numero;
	}


	public void setHoraireArrivee(long timeInMs) {
		horaireArrivee = timeInMs;
	}

	public long getHoraireArrivee() {
		return horaireArrivee;
	}

	public void setHoraireDepart(long timeInMs) {
		horaireDepart = timeInMs;
	}
}
