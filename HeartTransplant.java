/**
 * 
 * HeartTransplant class
 * 
 * @author Ashley Kurnit, ank103@rutgers.edu, ank103
 */
public class HeartTransplant {

    // patient array, each Patient is read from the data file
    private Patient[] patients;

    // SurvivabilityByAge array, each rate is read from data file
    private SurvivabilityByAge survivabilityByAge;

    // SurvivabilityByCause array, each rate is read from data file
    private SurvivabilityByCause survivabilityByCause;

    /*
     * Default constructor
     * Initializes patients to null.
     * Initializes survivabilityByAge to null.
     * Initializes survivabilityByCause to null. 
     */
    public HeartTransplant() {
        
        this.survivabilityByAge = null;
        this.survivabilityByCause = null;
        this.patients = null;
    }

    /*
     * Returns patients
     */
    public Patient[] getPatients() {
        return patients;
     } 

    /*
     * Returns survivabilityByAge
     */
    public SurvivabilityByAge getSurvivabilityByAge() {
        return survivabilityByAge;
    }

    /*
     * Returns survivabilityByCause
     */
    public SurvivabilityByCause getSurvivabilityByCause() {
        return survivabilityByCause;
    }

    /*
     * 1) Initialize the instance variable patients array with numberOfLines length.
     * 
     * 2) Reads from the command line data file, use StdIn.readInt() to read an integer.
     *    File Format: 
     *      ID, ethnicity, Gender, Age, Cause, Urgency, State of health
     * 
     *    Each line refers to one Patient, all values are integers.
     * 
     */
    public void readPatients (int numberOfLines) {
        // Initializing array with numberofLines length
        patients = new Patient[numberOfLines];

        for(int i = 0; i < numberOfLines; i++){
            // Reading data and filling up the array
            patients[i] = new Patient(StdIn.readInt(), StdIn.readInt(), StdIn.readInt(),
            StdIn.readInt(), StdIn.readInt(),  StdIn.readInt(), StdIn.readInt());
        }
    }

    /*
     * 1) Initialize the instance variable survivabilityByAge with a new survivabilityByAge object.
     * 
     * 2) Reads from the command line file to populate the object. 
     *    Use StdIn.readInt() to read an integer and StdIn.readDouble() to read a double.
     * 
     *    File Format: Age YearsPostTransplant Rate
     *    Each line refers to one survivability rate by age.
     * 
     */
    public void readSurvivabilityByAge (int numberOfLines) {
        // Initializes instance variable
        survivabilityByAge = new SurvivabilityByAge();
        //  Populating object with data
        for(int i = 0; i < numberOfLines; i++){
            survivabilityByAge.addData(StdIn.readInt(), StdIn.readInt(), StdIn.readDouble());
        }
    }

    /*
     * 1) Initialize the instance variable survivabilityByCause with a new survivabilityByCause object.
     * 
     * 2) Reads from the command line file to populate the object. Use StdIn.readInt() to read an 
     *    integer and StdIn.readDouble() to read a double.
     * 
     *    File Format: Cause YearsPostTransplant Rate
     *    Each line refers to one survivability rate by cause.
     * 
     */
    public void readSurvivabilityByCause (int numberOfLines) {
        // Intializing instance variable 

        survivabilityByCause = new SurvivabilityByCause();
        // Populating object with data
        for(int i = 0; i < numberOfLines; i++){
            survivabilityByCause.addData(StdIn.readInt(), StdIn.readInt(), StdIn.readDouble());
        }
    }
    
    /*
     * Returns a Patient array containing the patients, 
     * from the patients array, that have age above the parameter age.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of Patients with age above the parameter age.
     * 
     * Return null if there is no Patient with age above the 
     * parameter age.
     */ 
    public Patient[] getPatientsWithAgeAbove(int age) {
        int counter = 0;
        int j = 0;

        for(int i = 0; i < patients.length; i++){
            if(patients[i].getAge() >= age){
                counter += 1;
            }
        }
        Patient[] containingPatients = new Patient[counter];
        for(int i = 0; i < patients.length; i++){
            if(patients[i].getAge() >= age){
                containingPatients[j] = patients[i];
                j++;
            }
        }
        return containingPatients;
    }

    /*
     * Returns a Patient array containing the patients, from the patients array, 
     * that have the heart condition cause equal to the parameter cause.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of Patients with the heart condition cause equal to the parameter cause.
     * 
     * Return null if there is no Patient with the heart condition cause 
     * equal to the parameter cause.
     */ 
    public Patient[] getPatientsByHeartConditionCause(int cause) {
        int counter = 0;
        int j = 0;

        for(int i = 0; i < patients.length; i++) {
            if(patients[i].getCause() == cause){
                counter += 1;
            }
        }
        Patient[] containingPatients = new Patient[counter];
        for(int i = 0; i < patients.length; i++){
             if(patients[i].getCause() == cause){
                containingPatients[j] = patients[i];
                j++;
            }
        }
         return containingPatients;
    }

    /*
     * Returns a Patient array containing patients, from the patients array,
     * that have the state of health equal to the parameter state.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of Patients with the state of health equal to the parameter state.
     * 
     * Return null if there is no Patient with the state of health 
     * equal to the parameter state.
     */ 
    public Patient[] getPatientsByUrgency(int urgency) {
        int counter = 0;
        int j = 0;

        for(int i = 0; i < patients.length; i++) {
            if(patients[i].getUrgency() == urgency) {
                counter += 1;
                }
        }
        Patient[] containingPatients = new Patient[counter];
        for(int i = 0; i < patients.length; i++) {
            if(patients[i].getUrgency() == urgency) {
                containingPatients[j] = patients[i];
                j++;
            }
        }
        return containingPatients;
    }

    /*
     * Assume there is a heart available for transplantation surgery.
     * Also assume that the heart is of the same blood type as the
     * Patients on the patients array.
     * This method finds the Patient to be the recepient of this
     * heart.
     * 
     * The method returns a Patient from the patients array with
     * the highest potential for survivability after the transplant.
     * 
     * Assume the patient returned by this method will receive a heart,
     * therefore the Patient will no longer need a heart.
     * 
     * There is no correct solution, you may come up with any 
     * function to find the patient with the highest potential 
     * for survivability after the transplant.
     */ 
    public Patient getPatientForTransplant (){
        Patient[] containingPatients = getPatientsByUrgency(Patient.URGENCY_EXTREME);

        if(containingPatients.length == 0) {
            containingPatients = getPatientsByUrgency(Patient.URGENCY_MODERATE);
        }

        for(int i = 0; i < containingPatients.length; i++) {
            if(containingPatients[i].getStateOfHealth() == Patient.HEALTH_EXCELLENT && containingPatients[i].getNeedHeart() == true) {
                containingPatients[i].setNeedHeart(false);
                return containingPatients[i];
            }
        }

        for(int i = 0; i < containingPatients.length; i++) {
            if(containingPatients[i].getStateOfHealth() == Patient.HEALTH_EXCELLENT && containingPatients[i].getNeedHeart() == true) {
                containingPatients[i].setNeedHeart(false);
                return containingPatients[i];
                }
         }

        for(int i = 0; i < containingPatients.length; i++)  {
            if(containingPatients[i].getStateOfHealth() == Patient.HEALTH_GOOD && containingPatients[i].getNeedHeart() == true) {
                containingPatients[i].setNeedHeart(false);
                return containingPatients[i];
            }
        }

        for(int i = 0; i < containingPatients.length; i++) {
            if(containingPatients[i].getStateOfHealth() == Patient.HEALTH_POOR && containingPatients[i].getNeedHeart() == true)  {
                containingPatients[i].setNeedHeart(false);
            }
            return containingPatients[i];
        } 
        return patients[0];
    }
}
    