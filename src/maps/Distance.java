package maps;

public class Distance {

	public String destino;
	public int dis_seg;
	public int dis_m;
	public String timeTexto;
	public String kmTexto;
	
	public Distance(String destino, int dis_seg, int dis_m, String timeTexto, String kmTexto) {
		super();
		this.destino = destino;
		this.dis_seg = dis_seg;
		this.dis_m = dis_m;
		this.timeTexto = timeTexto;
		this.kmTexto = kmTexto;
	}
	
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public int getDis_seg() {
		return dis_seg;
	}
	public void setDis_seg(int dis_seg) {
		this.dis_seg = dis_seg;
	}
	public int getDis_m() {
		return dis_m;
	}
	public void setDis_m(int dis_m) {
		this.dis_m = dis_m;
	}
	public String gettimeTexto() {
		return timeTexto;
	}
	public void settimeTexto(String timeTexto) {
		this.timeTexto = timeTexto;
	}
	public String getkmTexto() {
		return kmTexto;
	}
	public void setkmTexto(String kmTexto) {
		this.kmTexto = kmTexto;
	}

	@Override
	public String toString() {
		return "Distance [destino=" + destino + ", segundos=" + dis_seg + ", metros=" + dis_m + ", String tiempo="
				+ timeTexto + ", String distanica=" + kmTexto + "]";
	}
	
	
}
