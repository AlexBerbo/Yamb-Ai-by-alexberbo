package com.comtrade.yamb.player;

import com.comtrade.yamb.Request;
import com.comtrade.yamb.RequestType;
import com.comtrade.yamb.Response;
import com.comtrade.yamb.player.igracGrupa1.IgracResponse;
import com.comtrade.yamb.player.igracGrupa1.Upisivanje;
import com.comtrade.yamb.player.igracGrupa1.YambKoloneBrojevi;
import com.comtrade.yamb.player.igracGrupa1.YambMetode;
import com.comtrade.yamb.player.igracGrupa1.YambUtils;

public class Player {
	static int najjacaPartija=0;
	static int brojPartija=6000;
	public Response play(Request request) {
		YambMetode metod = new YambMetode(request);
		YambUtils utils = new YambUtils();
		YambKoloneBrojevi upisiKolone = new YambKoloneBrojevi(request, metod, utils);
		Upisivanje upisi = new Upisivanje(metod, upisiKolone);
		IgracResponse response = null;
		if (request.getType()==RequestType.THROW) {
			response = (IgracResponse) upisi.logika(request);
		}
		/*
		 * if(request.getType()==RequestType.GAME_END) {
		 * if(request.getBoard().getScore()<brojPartija) {
		 * brojPartija=request.getBoard().getScore();
		 * najjacaPartija=request.getGameNumber(); } }
		 * if(request.getType()==RequestType.GAME_END) {
		 * System.out.println("Najslabiji skor je: " + brojPartija);
		 * System.out.println("Najslabija partija je: " + najjacaPartija); }
		 */
		return response;
	}
}
