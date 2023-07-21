#include <stdio.h>

int main(){

    float userGrade1, userGrade2, userGrade3, userFinalGrade;
    printf("Enter your 3 grades: ");
    scanf("%f %f %f", &userGrade1, &userGrade2, &userGrade3);

    userFinalGrade = (userGrade1 + userGrade2 + userGrade3) / 3;

    if(userFinalGrade >= 60){
        printf("Approved");
    }else{
        printf("Disapproved");
    }

    return 0;
}

