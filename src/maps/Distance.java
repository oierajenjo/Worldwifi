package maps;

public class Distance {

	public String destino;
	public int dis_seg;
	public int dis_km;
	
	
	public Distance(String destino, int dis_seg, int dis_km) {
		super();
		this.destino = destino;
		this.dis_seg = dis_seg;
		this.dis_km = dis_km;
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
	
	public int getDis_km() {
		return dis_km;
	}
	
	public void setDis_km(int dis_km) {
		this.dis_km = dis_km;
	}

	@Override
	public String toString() {
		return "Distance [Destino=" + destino + ", distancia en segundos=" + dis_seg + ", distancia en km=" + dis_km + "]";
	}
	
	
}
