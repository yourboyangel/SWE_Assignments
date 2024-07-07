import java.util.Random;

//Exercise 9
public class SortPersonsInLinearTime {
    public Person[] sort(Person[] persons){
        int[] ageCnt=new int[961];

        for(Person person: persons){
            ageCnt[person.age]++;
        }

        int i=0;
        for(int age=960; age>=0; age--){
            while(ageCnt[age]>0) {
                persons[i++] = new Person("", age);
                ageCnt[age]--;
            }
        }
        return persons;
    }

    public Person[] randomPersonGenerator(){
        Person[] persons = new Person[1000];
        Random random = new Random();
        for(int i=0; i<1000; i++){
            String fullName="Person "+i;
            int age=random.nextInt(960);
            persons[i]=new Person(fullName, age);

        }
        return persons;
    }

    public static void main(String[] args) {
        SortPersonsInLinearTime sorting= new SortPersonsInLinearTime();
        Person [] persons= sorting.randomPersonGenerator();
        sorting.sort(persons);
        for(Person person : persons){
            System.out.println("Name: "+person.fullName+" Age: "+person.age);
        }
     }
}
