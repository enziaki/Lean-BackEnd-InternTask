# Lean Platform Technology BackEnd Intern Task


# Objectives The application should have the following features:
+ Rate Mentor- There is a mentor and a user table. Now, a user should be able
  to give a rating to a mentor out of 5 stars. And after the rating the overall
  rating of the mentor should also change.
+ Review Mentor- User should be able to give a review to the mentor (in 50
  words).
+ Get Mentor Details - Users should be able to get mentors by selecting ratings
  (either 1,2,3,4,5) and all the mentors along with their reviews should be
  sent to the user.  4.Recommend Student- Mentor should be able to recommend a
  student i.e they can give them a letter of recommendation which should be
  shareable to everyone via link. i.e there should be an api which anyone can
  hit and should be able to see the letter of recommendation.

# Installation

The project uses Gradle as it's build tool. Navigate to the directory where the
project is cloned and enter:

```bash
./gradlew build
```

After building the application, it will stored in `./build/libs`. Navigate to that directory and enter:

```bash
cd build/libs
java -jar demo-0.0.1-SNAPSHOT.jar
```

# API EndPoints

#### Students

+ `http://localhost:6969/api/students` - GET all Students
+ `/api/students/{id}` - GET a single student by ID
+ `/api/student` - POST. Add a student
+ `/api/student/{id}` - PUT. Update a student record
+ `/api/students/{id}` - DELETE a single student by ID
+ `/api/submit-reveiew` - POST. Submit review for a mentor


#### Mentor

+ `/api/mentors` - GET all of the Mentors
+ `/api/mentor/{id}` - GET a single Mentor
+ `/api/ratings/{rating}` - GET Mentors through ratings
+ `/api/mentors` - POST. Add mentors

#### Reviews

+ `/api/reviews` - GET all reviews
+ `/api/reviews/mentor/{mentor_id}` - GET reviews for a specific mentor
+ `/api/reviews/submit` - POST. Submit a review or a mentor

#### RecommendStudent

+ `/api/recommend` - GET all recommendation
+ `/api/recommend/{id}` - GET a recommendation through recommendation id
+ `/api/recommend` - POST new recommendation
+ `/api/recommend/{id}` - PUT. Update recommendation
+ `/api/recommend/{id}` - DELETE a recommendation


# Test Cases

#### Test Case 1

+ Requirements: Mentor Table end points.
+ Status: All of the specified endpoints work as intended.
+ Additional Notes: NA

#### Test Case 2

+ Requirements: Student Table end points
+ Status: All of the specified endpoints work as intended.
+ Additional Notes: NA

### Test Case 3

+ Requirements: Review Table and it's endpoints
+ Status: All of the specified endpoints work as intended
+ Additional Notes: NA

### Test case 4

+ Requirements: RecommendStudent Table and it's endpoints
+ Status: All of the specified endpoints work as intended
+ Additional Notes: NA


