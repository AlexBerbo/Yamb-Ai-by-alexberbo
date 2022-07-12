package com.comtrade.yamb.player.igracGrupa1;

import java.util.Arrays;

import com.comtrade.yamb.Constants;
import com.comtrade.yamb.Die;
import com.comtrade.yamb.Request;
import com.comtrade.yamb.RequestType;

public class YambMetode{
	Request request;
	YambKoloneBrojevi metodeBrojevi;
	public YambMetode(Request request) {
		this.request=request;
	}
	
	public int[] generisiBrojacKockica() {
		int[] brojacKockica = null;
		if(request.getType()==RequestType.THROW) {
			Die[] kockica=request.getDice();
			int i;
			brojacKockica=new int[Constants.DICE_COUNT+1];
			
			for(i=0;i<Constants.DICE_COUNT;i++) {
				brojacKockica[kockica[i].getValue()]++;
			}
		}
		return brojacKockica;
	}

	public boolean[] cuvajKockice(int kockica) {
		boolean[] nizKockica = null;
		if(request.getType()==RequestType.THROW) {
			Die[] kockice=request.getDice();
			nizKockica=new boolean[Constants.DICE_COUNT];
			for(int i=0;i<Constants.DICE_COUNT;i++) {
				if(kockice[i].getValue()==kockica) {
					nizKockica[i]=true;
				}
				else {
					nizKockica[i]=false;
				}
			}
		}
		return nizKockica;
	}
	
	public boolean[] cuvajKockiceMin() {
		boolean[] nizKockica = null;
		if(request.getType()==RequestType.THROW) {
			Die[] kockice=request.getDice();
			nizKockica=new boolean[Constants.DICE_COUNT];
			for(int i=0;i<Constants.DICE_COUNT;i++) {
				if(kockice[i].getValue()==1 || kockice[i].getValue()==2) {
					nizKockica[i]=true;
				}
				else {
					nizKockica[i]=false;
				}
			}
		}
		return nizKockica;
	}
	
	public boolean[] cuvajKockiceMax() {
		boolean[] nizKockica = null;
		if(request.getType()==RequestType.THROW) {
			Die[] kockice=request.getDice();
			nizKockica=new boolean[Constants.DICE_COUNT];
			for(int i=0;i<Constants.DICE_COUNT;i++) {
				if(kockice[i].getValue()==5 || kockice[i].getValue()==6) {
					nizKockica[i]=true;
				}
				else {
					nizKockica[i]=false;
				}
			}
		}
		return nizKockica;
	}
	
	public int brojNajveceKockice() {
		int maxNumber=0;
		if(request.getType()==RequestType.THROW) {
			Die[] kockice=request.getDice();
			maxNumber = kockice[0].getValue();
			for (int i = 0; i < Constants.DICE_COUNT; i++){
				if (kockice[i].getValue() > maxNumber){
					maxNumber = kockice[i].getValue();
		        }
		    }
		}
	    return maxNumber;
	}
	
	public int brojNajmanjeKockice() {
		int minNumber=0;
		if(request.getType()==RequestType.THROW) {
			Die[] kockice=request.getDice();
			minNumber = kockice[0].getValue();
			for (int i = 0; i < Constants.DICE_COUNT; i++){
				if (kockice[i].getValue() < minNumber){
					minNumber = kockice[i].getValue();
		        }
		    }
		}
	    return minNumber;
	}
	
	public int max() {
		int max=0;
		if(request.getType()==RequestType.THROW) {
			Die[] kockice=request.getDice();
			int[] nizKockice=new int[Constants.DICE_COUNT];
			for(int j=0; j<Constants.DICE_COUNT;j++) {
				nizKockice[j]=kockice[j].getValue();
			}
			Arrays.sort(nizKockice);
			for(int i=1;i<Constants.DICE_COUNT;i++) {
				max=max+nizKockice[i];
			}
			return max;
		}
	    return max;
	}
	
	public int min() {
		int min=0;
		if(request.getType()==RequestType.THROW) {
			Die[] kockice=request.getDice();
			int[] nizKockice = new int[Constants.DICE_COUNT];
			for(int j=0; j<Constants.DICE_COUNT;j++) {
				nizKockice[j]=kockice[j].getValue();
			}
			Arrays.sort(nizKockice);
			for(int i=0;i<Constants.DICE_COUNT-1;i++) {
				min=min+nizKockice[i];
			}
			return min;
		}
	    return min;
	}
	
	public boolean kenta() {
		int[] niz=generisiBrojacKockica();
        if (kenta2Do5() == true && (niz[1] > 0 || niz[6] > 0)) {
            return true;
        }
        return false;
    }
	
	public boolean kenta2Do5(){
		boolean ideKenta = false;
		int[] niz=generisiBrojacKockica();
		for(int i = 2; i < Constants.DICE_COUNT; i++){
			if(niz[i] > 0) {
				ideKenta = true;
			} 
	        else{
	        	ideKenta = false;
	            break;
	        }
	    }
	    return ideKenta;
	}
	
	public boolean full() {//MORA BITI SAVRSENO!!
		 int[] brojacKockica;
		 brojacKockica=generisiBrojacKockica();
		 boolean full=false;
		 
		 for(int i=1;i<=brojacKockica.length-1;i++) {
			 for(int j=i+1; j<brojacKockica.length;j++) {
				 if(brojacKockica[i]==5 || brojacKockica[i]==6) {
					 full=true;
				 }
				 else if(brojacKockica[i]==3 && brojacKockica[j]==2 || brojacKockica[i]==2 && brojacKockica[j]==3) {
					 full=true;
				 }
			 }
		 }
		 return full;
	 }
	 
	 public boolean threeOfaKind() {
		 int[] brojacKockica;
		 brojacKockica=generisiBrojacKockica();
		 
		 boolean threeOfaKind=false;
		 int i;
		 
		 for(i=1;i<=Constants.DICE_COUNT;i++) {
			 if(brojacKockica[i]>=3) {
				 threeOfaKind=true;
			 }
		 }
		 return threeOfaKind;
	 }
	 
	 public boolean fourOfaKind() {
		 int[] brojacKockica;
		 brojacKockica=generisiBrojacKockica();
		 
		 boolean fourOfaKind=false;
		 int i;
		 
		 for(i=1;i<=Constants.DICE_COUNT;i++) {
			 if(brojacKockica[i]>=4) {
				 fourOfaKind=true;
			 }
		 }
		 return fourOfaKind;
	 }

	public boolean fiveOfaKind() {
		 int[] brojacKockica;
		 brojacKockica=generisiBrojacKockica();
		 
		 boolean fiveOfaKind=false;
		 int i;
		 
		 for(i=1;i<=Constants.DICE_COUNT;i++) {
			 if(brojacKockica[i]>=5) {
				 fiveOfaKind=true;
			 }
		 }
		 return fiveOfaKind;
	 }
	
	public boolean dupliPar() {
		int[] brojacKockica;
		brojacKockica=generisiBrojacKockica();
		boolean dupliPar=false;
		
		if((brojacKockica[1] > 1 && brojacKockica[1] < 3 && brojacKockica[2]> 1 && brojacKockica[2] < 3) || (brojacKockica[1] > 1 && brojacKockica[1] < 3 && brojacKockica[3] > 1 && brojacKockica[3] < 3) || 
				(brojacKockica[1] > 1 && brojacKockica[1] < 3 && brojacKockica[4] > 1 && brojacKockica[4] < 3) || (brojacKockica[1] > 1 && brojacKockica[1] < 3 && brojacKockica[5]> 1 && brojacKockica[5] < 3) || 
				(brojacKockica[1] > 1 && brojacKockica[1] < 3 && brojacKockica[6] > 1 && brojacKockica[6] < 3) ||
				(brojacKockica[2] > 1 && brojacKockica[2] < 3 && brojacKockica[3] > 1 && brojacKockica[2] < 3) || (brojacKockica[2] > 1 && brojacKockica[2] < 3 && brojacKockica[4] > 1 && brojacKockica[4] < 3) || 
				(brojacKockica[2] > 1 && brojacKockica[2] < 3 && brojacKockica[5] > 1 && brojacKockica[5] < 3) || (brojacKockica[2] > 1 && brojacKockica[2] < 3 && brojacKockica[6] > 1 && brojacKockica[6] < 3) ||
			    (brojacKockica[3] > 1 && brojacKockica[3] < 3 && brojacKockica[4] > 1 && brojacKockica[4] < 3) || (brojacKockica[3] > 1 && brojacKockica[3] < 3 && brojacKockica[5] > 1 && brojacKockica[5] < 3) || 
			    (brojacKockica[3] > 1 && brojacKockica[3] < 3 && brojacKockica[6] > 1 && brojacKockica[6] < 3) ||
			    (brojacKockica[4] > 1 && brojacKockica[4] < 3 && brojacKockica[5] > 1 && brojacKockica[5] < 3) || (brojacKockica[4] > 1 &&  brojacKockica[4] < 3 && brojacKockica[6] > 1 && brojacKockica[6] < 3) ||
			    (brojacKockica[5] > 1 && brojacKockica[5] < 3 && brojacKockica[6] > 1 && brojacKockica[6] < 3)) {
				   dupliPar = true;
		}
		return dupliPar;
	}
}
