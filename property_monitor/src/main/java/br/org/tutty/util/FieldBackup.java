package br.org.tutty.util;


public class FieldBackup {
	
	 private String name;
     private Object value;
     private Boolean changedFlag;

     FieldBackup(String name, Object value) {
         this.name = name;
         this.value = value;
         this.changedFlag = Boolean.FALSE;
     }

	public void setChangedFlag(Boolean changedFlag) {
		this.changedFlag = changedFlag;
	}

	public String getName() {
		return name;
	}

	public Object getValue() {
		return value;
	}
	
	public void analyzeChangeValue(Object newValue){
		if(!newValue.equals(value)){
			changedFlag = Boolean.TRUE;
			
		}else {
			changedFlag = Boolean.FALSE;
		}
	}

    public Boolean hasChanged(){
		return changedFlag;
	}
}
