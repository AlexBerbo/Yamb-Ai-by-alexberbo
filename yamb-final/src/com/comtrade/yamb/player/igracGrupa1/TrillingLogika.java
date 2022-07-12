package com.comtrade.yamb.player.igracGrupa1;

import com.comtrade.yamb.Request;
import com.comtrade.yamb.RequestType;
import com.comtrade.yamb.Response;

public class TrillingLogika {
	static YambKoloneBrojevi koloneBrojevi;
	static YambUtils utils;
	static YambMetode metode;
	static KentaLogika kentaLogika=new KentaLogika();
	static PokerLogika pokerLogika=new PokerLogika();
	static FullLogika fullLogika=new FullLogika();
	static TrillingLogika trillingLogika=new TrillingLogika();
	static MinimumLogika logikaMin=new MinimumLogika();
	
	public static Response logikaTrilling(Request request) { //metod koji vrsi logiku upisivanja trilling-a
		metode=new YambMetode(request);
		koloneBrojevi=new YambKoloneBrojevi(request, metode, utils);
		if(request.getType()==RequestType.THROW) { //kada obrisem ovde if(request.getType()==RequestType.THROW) smanji se skor za 30.
			if(request.getThrowNumber()==Konstrakte.PRVO_BACANJE) {
				if(YambKoloneBrojevi.isColumnPlayedForAllNumberFields(11)) {
					if(YambKoloneBrojevi.isColumnPlayableForNumberFieldPrvoBacanje(5)){
						return SesticeLogika.sestice(request);
					}
					if(YambKoloneBrojevi.isColumnPlayableForNumberFieldPrvoBacanje(4)){
						return PeticeLogika.petice(request);
					}
					if(YambKoloneBrojevi.isColumnPlayableForNumberFieldPrvoBacanje(3)){
						return CetvorkeLogika.cetvorke(request);
					}
					if(YambKoloneBrojevi.isColumnPlayableForNumberFieldPrvoBacanje(2)){
						return TrojkeLogika.trojke(request);
					}
					if(YambKoloneBrojevi.isColumnPlayableForNumberFieldPrvoBacanje(1)){
						return DvojkeLogika.dvojke(request);
					}
					if(YambKoloneBrojevi.isColumnPlayableForNumberFieldPrvoBacanje(0)){
						return KeceviLogika.kecevi(request);
					}
				}
				if(YambUtils.ucestalostBrojeva(request, 1, 2)) {
					return KeceviLogika.kecevi(request);
				}
				if(metode.threeOfaKind()) {
					if(YambUtils.ucestalostBrojeva(request, 2,3)) {
						return DvojkeLogika.dvojke(request);
					}
					if(YambUtils.ucestalostBrojeva(request, 3,3)) {
						return TrojkeLogika.trojke(request);
					}
					if(metode.fourOfaKind()) {
						if(YambUtils.ucestalostBrojeva(request, 1,4)) {
							return KeceviLogika.kecevi(request);
						}
						if(YambUtils.ucestalostBrojeva(request, 2,4)) {
							return DvojkeLogika.dvojke(request);
						}
						if(YambUtils.isPlayable(request, 0, 13) || YambUtils.isPlayable(request, 1, 13) || YambUtils.isPlayable(request, 2, 13) || YambUtils.isPlayable(request, 3, 13) || YambUtils.isPlayable(request, 4, 13)) {
							return PokerLogika.logikaPoker(request);
						}
					}
					int[] redosledTrilling = new int[] {6, 5, 2, 3, 4, 0, 1};
					return YambUtils.findResponseByPriorityTrece(redosledTrilling, request, 11);
				}
			}
		}
		else if(request.getThrowNumber()==Konstrakte.DRUGO_BACANJE) {
			if(YambKoloneBrojevi.isColumnPlayedForAllNumberFields(11)) {
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(5)){
					return SesticeLogika.sestice(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(4)){
					return PeticeLogika.petice(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(3)){
					return CetvorkeLogika.cetvorke(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(2)){
					return TrojkeLogika.trojke(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(1)){
					return DvojkeLogika.dvojke(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(0)){
					return KeceviLogika.kecevi(request);
				}
			}
			if(metode.threeOfaKind()) {
				if(metode.fourOfaKind()) {
					if(YambUtils.ucestalostBrojeva(request, 1,4)) {
						return KeceviLogika.kecevi(request);
					}
					if(YambUtils.ucestalostBrojeva(request, 2,4)) {
						return DvojkeLogika.dvojke(request);
					}
					if(YambUtils.isPlayable(request, 0, 13) || YambUtils.isPlayable(request, 1, 13) || YambUtils.isPlayable(request, 2, 13) || YambUtils.isPlayable(request, 3, 13) || YambUtils.isPlayable(request, 4, 13)) {
						return PokerLogika.logikaPoker(request);
					}
				}
				int[] redosledTrilling = new int[] {2, 3, 4, 0, 1};
				return YambUtils.findResponseByPriorityTrece(redosledTrilling, request, 11);
			}
		}
		else if(request.getThrowNumber()==Konstrakte.TRECE_BACANJE) {
			if(YambKoloneBrojevi.isColumnPlayedForAllNumberFields(11)) {
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(5)){
					return SesticeLogika.sestice(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(4)){
					return PeticeLogika.petice(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(3)){
					return CetvorkeLogika.cetvorke(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(2)){
					return TrojkeLogika.trojke(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(1)){
					return DvojkeLogika.dvojke(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(0)){
					return KeceviLogika.kecevi(request);
				}
			}
			if(metode.threeOfaKind()) {
				if(metode.fourOfaKind()) {
					if(YambUtils.ucestalostBrojeva(request, 1,4)) {
						return KeceviLogika.kecevi(request);
					}
					if(YambUtils.ucestalostBrojeva(request, 2,4)) {
						return DvojkeLogika.dvojke(request);
					}
					if(YambUtils.isPlayable(request, 0, 13) || YambUtils.isPlayable(request, 1, 13) || YambUtils.isPlayable(request, 2, 13) || YambUtils.isPlayable(request, 3, 13) || YambUtils.isPlayable(request, 4, 13)) {
						return PokerLogika.logikaPoker(request);
					}
				}
				int[] redosledTrilling = new int[] {2, 3, 0, 4, 1};
				return YambUtils.findResponseByPriorityTrece(redosledTrilling, request, 11);
			}
			else {
				return koloneBrojevi.svePoDva();
			}
		}
		return null;
	}
}
