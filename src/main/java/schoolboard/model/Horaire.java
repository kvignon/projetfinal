package schoolboard.model;

	import java.util.Date;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.Id;
	import javax.persistence.IdClass;
	import javax.persistence.JoinColumn;
	import javax.persistence.ManyToOne;
	import javax.persistence.Temporal;
	import javax.persistence.TemporalType;
	import javax.persistence.Version;

	@Entity
	public class Horaire {

		private Date heureDeb;
		private Date heureFin;
		private Date date;
		private int version;
		
		public Horaire(Date heureDeb, Date heureFin, Date date, int version) {
			super();
			this.heureDeb = heureDeb;
			this.heureFin = heureFin;
			this.date = date;
			this.version = version;
		}

		public Horaire() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Date getHeureDeb() {
			return heureDeb;
		}

		public void setHeureDeb(Date heureDeb) {
			this.heureDeb = heureDeb;
		}

		public Date getHeureFin() {
			return heureFin;
		}

		public void setHeureFin(Date heureFin) {
			this.heureFin = heureFin;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public int getVersion() {
			return version;
		}

		public void setVersion(int version) {
			this.version = version;
		}
		
}
