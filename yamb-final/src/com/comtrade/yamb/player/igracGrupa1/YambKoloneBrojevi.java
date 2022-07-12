package com.comtrade.yamb.player.igracGrupa1;

import com.comtrade.yamb.Constants;
import com.comtrade.yamb.Request;
import com.comtrade.yamb.Response;

public class YambKoloneBrojevi {
	static Request request;
	YambMetode metode;
	YambUtils utils;
	KeceviLogika keceviLogika=new KeceviLogika();
	DvojkeLogika dvojkeLogika=new DvojkeLogika();
	TrojkeLogika trojkeLogika=new TrojkeLogika();
	CetvorkeLogika cetvorkeLogika=new CetvorkeLogika();
	PeticeLogika peticeLogika=new PeticeLogika();
	SesticeLogika sesticeLogika=new SesticeLogika();
	YambLogika yambLogika=new YambLogika();
	PokerLogika pokerLogika=new PokerLogika();
	TrillingLogika trillingLogika=new TrillingLogika();
	FullLogika fullLogika=new FullLogika();
	KentaLogika kentaLogika=new KentaLogika();
	MinimumLogika minLogika=new MinimumLogika();
	MaximumLogika maxLogika=new MaximumLogika();
	
	public YambKoloneBrojevi(Request request, YambMetode metode, YambUtils utils) {
		YambKoloneBrojevi.request=request;
		this.metode=metode;
		this.utils=utils;
	}
	
	
	
	//NumberField - kolone od 0-6
	public static boolean isColumnPlayableForNumberFieldPrvoBacanje(int red) {
		for(int i = 0; i <=Constants.DICE_COUNT; i++) {
			if (YambUtils.isPlayable(request, i, red))
				return true;
		}
		return false;
	}
	
	public static boolean isColumnNotPlayableForNumberFieldPrvoBacanje(int red) {
		for(int i = 0; i <=Constants.DICE_COUNT; i++) {
			if (YambUtils.isPlayable(request, i, red))
				return true;
		}
		return false;
	}
	
	//NumberField - kolone od 0-4
	public static boolean isColumnPlayableForNumberFieldDrugoiTreceBacanje(int red) {
		for(int i = 0; i <=4; i++) {
			if (YambUtils.isPlayable(request, i, red))
				return true;
		}
		return false;
	}
	
	public static boolean isColumnNotPlayableForNumberFieldDrugoiTreceBacanje(int red) {
		for(int i = 0; i <=4; i++) {
			if(!YambUtils.isPlayable(request, i, red))
				return true;
		}
		return false;
	}
	
	//NumberField - kolone od 0-6
	public static boolean isColumnPlayedForAllNumberFields(int red) {
		for(int i = 0; i <=Constants.DICE_COUNT; i++) {
			if (!YambUtils.isPlayed(request, i, red))
				return false;
		}
		return true;
	}
	
	public Response svePoDva() { //metod koji vraca program na da upisuje brojeve od 1 do 6 u slucaju da ih je po dva ili vise
		if(YambUtils.ucestalostBrojeva(request, 1,2)) {
			return KeceviLogika.kecevi(request);
		}
		if(YambUtils.ucestalostBrojeva(request, 2,2)) {
			return DvojkeLogika.dvojke(request);
		}
		if(YambUtils.ucestalostBrojeva(request, 3,2)) {
			return TrojkeLogika.trojke(request);
		}
		if(YambUtils.ucestalostBrojeva(request, 4,2)) {
			return CetvorkeLogika.cetvorke(request);
		}
		if(YambUtils.ucestalostBrojeva(request, 5,2)) {
			return PeticeLogika.petice(request);
		}
		if(YambUtils.ucestalostBrojeva(request, 6,2)) {
			return SesticeLogika.sestice(request);
		}
		return null;
	}
	
	public Response pozoviLogiku(Request request) { //metod koji se poziva u glavnom programu da bih se dobio score
		Response response=null;
		if(YambLogika.logikaYamb(request)!=null){
			response=YambLogika.logikaYamb(request);
			return response;
		}
		if(MinimumLogika.min(request)!=null){
			response=MinimumLogika.min(request);
			return response;
		}
		if(KentaLogika.logikaKenta(request)!=null){
			response=KentaLogika.logikaKenta(request);
			return response;
		}
		if(PokerLogika.logikaPoker(request)!=null){
			response=PokerLogika.logikaPoker(request);
			return response;
		}
		if(FullLogika.logikaFull(request)!=null){
			response=FullLogika.logikaFull(request);
			return response;
		}
		if(MaximumLogika.max(request)!=null){
			response=MaximumLogika.max(request);
			return response;
		}
		if(SesticeLogika.sestice(request)!=null){
			response=SesticeLogika.sestice(request);
			return response;
		}
		if(PeticeLogika.petice(request)!=null){
			response=PeticeLogika.petice(request);
			return response;
		}
		if(TrillingLogika.logikaTrilling(request)!=null){
			response=TrillingLogika.logikaTrilling(request);
			return response;
		}
		if(CetvorkeLogika.cetvorke(request)!=null){
			response=CetvorkeLogika.cetvorke(request);
			return response;
		}
		if(TrojkeLogika.trojke(request)!=null){
			response=TrojkeLogika.trojke(request);
			return response;
		}	
		if(KeceviLogika.kecevi(request)!=null){
			response=KeceviLogika.kecevi(request);
			return response;
		}
		if(DvojkeLogika.dvojke(request)!=null){
			response=DvojkeLogika.dvojke(request);
			return response;
		}
		return null;
	}
}
