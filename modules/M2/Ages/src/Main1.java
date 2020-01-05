public class Main1 {
    public static void main(String[] args) {
        var vasyaAge = 15;
        var katyaAge = 70;
        var mishaAge = 2;

        var min = -1;
        var middle = -1;
        var max = -1;

        if (vasyaAge < katyaAge && vasyaAge < mishaAge) {
            min = vasyaAge;
        }
        if (katyaAge < vasyaAge && katyaAge < mishaAge) {
            min = katyaAge;
        }
        if (mishaAge < vasyaAge && mishaAge < katyaAge) {
            min = mishaAge;
        }
        if ((vasyaAge < katyaAge && vasyaAge > mishaAge) || (vasyaAge > katyaAge && vasyaAge < mishaAge)) {
            middle = vasyaAge;
        }
        if ((katyaAge < vasyaAge && katyaAge > mishaAge) || (katyaAge < mishaAge && katyaAge > vasyaAge)) {
            middle = katyaAge;
        }
        if ((mishaAge < vasyaAge && mishaAge > katyaAge) || (mishaAge < katyaAge && mishaAge > vasyaAge)) {
            middle = mishaAge;
        }
        if (vasyaAge > katyaAge && vasyaAge > mishaAge) {
            max = vasyaAge;
        }
        if (katyaAge > vasyaAge && katyaAge > mishaAge) {
            max = katyaAge;
        }
        if (mishaAge > vasyaAge && mishaAge > katyaAge) {
            max = mishaAge;
        }

        System.out.println("Minimal age:" + min);
        System.out.println("Middle age:" + middle);
        System.out.println("Maximum age:" + max);
    }
}