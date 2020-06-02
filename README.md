# Prediction-of-Hospital-Length-of-Stay
Prediction of the duration of stay in hospital for a particular patient is of significant value since it helps to reduce the incurred expenses as well as in resource planning and management of the hospital. This system estimates the of length of stay for the patient diagnosed with various diseases and include both ICU and post ICU stay.

## Dataset and tables used
The dataset we have utilized is the [MIMIC III database](https://mimic.physionet.org/) which has more than 50,000 real records of individuals that have been admitted to ICU units somewhere in the range of 2001 and 2012. Our objective is to gauge patient’s duration of complete stay in the hospital including both ICU stay and post ICU stay. For that the input to the system contains characteristics from the following tables:
1. Admissions: row id, hadm id, subject id, admittime, dis- chtime, ethnicity, admission type, edregtime, edouttime, deathtime.
2. Diagnoses ICD: subject id, hadm id, ICD9 code
3. D ICD diagnoses: ICD9 code, short title, long title
4. Patients: subject id, gender, dobPre


## Regression
Regression analysis is a significant instrument for demon- strating and breaking down information. It is a type of prescient displaying procedure which explores the connection between a reliant (target) and autonomous variable (s) (indica- tor). This method is utilized for prediction, time arrangement displaying and finding the causal impact connection between the factors. For example, correlation between rash driving and number of street mishaps by a driver is best calculated through regression.The formula to calculate multiple regression is given as: p = qy1 + qy2+ qy3+ c where,
- p = dependent variable of the regression
- q = slope of the regression
- y1 = first independent variable of the regression
- y2 = second independent variable of the regression
- y3 = third independent variable of the regression
- c = constant

<img src="https://user-images.githubusercontent.com/30766392/83519208-33238800-a4f9-11ea-8ead-0db6d8054c36.jpeg"/>

## Preprocessing
In data preprocessing we adjusted the patient’s date of birth column which was encoded to ensure the patient’s privacy protection, so wherever the DOB is in the 2000s, the year is subtracted by 100 and wherever it is in 2100s, the year is subtracted by 200. 
The information of patients who have multiple diseases has been joined into a single row to decrease the redundancy in the dataset, for this a new table symptoms icd is created which aggregates all of the patients and diseases and creates a single entry for each admission.

We created a new column for length of stay in Admissions table by calculating the difference between the date of release and date of admission of the patient. The diagnosis categories are the most important feature in predicting the LOS.
<img src="https://user-images.githubusercontent.com/30766392/83521432-d9bd5800-a4fc-11ea-9845-9e8705c42096.png" />

We then reduced the hospital admissions to four categories: urgent, newborn, emergency, elective. Newborns have the lowest median LOS whereas the urgent category has the highest. Elective admissions have a tighter distribution that favors a lower LOS, which makes sense since the severity of such conditions is usually less time critical.
<img src="https://user-images.githubusercontent.com/30766392/83521649-26a12e80-a4fd-11ea-89dc-ee776cc82f9c.png" />

