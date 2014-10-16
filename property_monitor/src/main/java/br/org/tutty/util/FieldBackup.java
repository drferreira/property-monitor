package br.org.tutty.util;


public class FieldBackup {
	
	 private String name;
     private Object value;
     private Boolean changedFlag;

     FieldBackup(String name, Object value) {
         this.name = name;
         this.value = value;
         resetChangedFlag();
     }

	public String getName() {
		return name;
	}

	public Object getValue() {
		return value;
	}

    public void resetChangedFlag(){
        this.changedFlag = Boolean.FALSE;
    }
	
	public void analyzeChangeValue(Object newValue){
        if(newValue != null){
            if(!newValue.equals(value)){
                changedFlag = Boolean.TRUE;

            }else {
                changedFlag = Boolean.FALSE;
            }
        }else {
           if(newValue != value){
               changedFlag = Boolean.TRUE;
           }else {
               changedFlag = Boolean.FALSE;
           }
        }
	}

    public Boolean hasChanged(){
		return changedFlag;
	}
}
