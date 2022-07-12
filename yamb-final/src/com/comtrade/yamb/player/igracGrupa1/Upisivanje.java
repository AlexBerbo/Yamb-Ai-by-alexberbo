package com.comtrade.yamb.player.igracGrupa1;

import com.comtrade.yamb.Request;
import com.comtrade.yamb.Response;

public class Upisivanje {
	
	YambMetode metode;
	YambKoloneBrojevi pozoviLogiku;
	public Upisivanje(YambMetode metode, YambKoloneBrojevi pozoviLogiku) {
		this.metode=metode;
		this.pozoviLogiku=pozoviLogiku;
	}
	
	public Response logika(Request request) {
		Response response=pozoviLogiku.pozoviLogiku(request);
		return response;
	}
}
