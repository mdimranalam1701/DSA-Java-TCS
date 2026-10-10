import java.util.*;
public class Array {
public static void update(int marks[],int nonchangable){
     nonchangable = 10;
    for(int i=0;i<marks.length;i++){
        marks[i]= marks[i] +1;
    }
}

//liner search
public static int linearsearch(int number[],int key){
    for(int i=0;i<number.length;i++){
        if(number[i] == key){
            return i;
        }
    }
    return -1;
}
public static void main(String args[]){
//     int marks[] = {99,98,95};
//     int nonchangable = 5;
//     update(marks,nonchangable);
//     System.out.println(nonchangable); //no chnage op 5
// //print array
//     for(int i=0;i<marks.length;i++){
//         System.out.println("marks are"+marks[i]);
//     }

//Linear search
int  number[] = { 2,3,45,6,8,7,9,5,6,31,16,41,16,};
int key = 10;

int index = linearsearch(number, key);
if(index != -1){
    System.out.println(index);
}else{
    System.out.println("key not found");
}

}
}

