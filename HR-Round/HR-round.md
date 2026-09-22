//1 tell me about you self??
Good afternoon. My name is MD Imran Alam. I recently graduated with a degree in Computer Science and Engineering from Techno International Batanagar, with a CGPA of 7.83, and my last semester CGPA was 8.84.

I've always had a strong interest in software development, and during my degree I've worked with technologies like Java, JavaScript, React, Node.js, SQL, and MongoDB. Working on different projects helped me understand not just coding, but how a software application is designed, developed, and turned into a meaningful product for real-world use.

Currently, I'm also working as an intern at Millions Tech, where I'm involved in developing a full-stack application for the real-estate and vehicle-rental domain. My main work has been on the backend, where I worked on features that allow vehicle owners to list their vehicles and customers to rent them. I also worked on a four-step KYC process for driver verification and implemented a secure payment pipeline using Stripe. This experience gave me exposure to developing features for a real-world application and working with business requirements.

Apart from my internship, one of my major academic projects is SafeStree, which is a smart surveillance and women's safety application that my team and I developed. It integrates with CCTV cameras to detect potential incidents and generate alerts for the concerned authorities. We also worked on features like voice-triggered SOS alerts, emergency contacts, and a safe-route feature to help users find safer routes to their destination. I contributed to both the backend and frontend development of the application.

Overall, I would describe myself as someone who enjoys solving practical problems through technology. At this stage of my career, I'm looking for an opportunity where I can work on real-world projects, strengthen my technical skills, learn from experienced developers, and gradually take more responsibility.


//You mentioned your internship at Millions Tech. Can you explain what exactly you worked on and what your individual contribution was?

At Millions Tech, I worked on the backend of a vehicle-rental application. The system consisted of two mobile applications — one for vehicle owners and one for drivers — along with a CRM or admin dashboard.

My main responsibility was developing backend APIs and business logic according to the requirements. In the admin dashboard, administrators can monitor things like total users, listed vehicles, drivers, rentals, and revenue. They can also verify driver identities before allowing them to use the platform.

On the owner side, vehicle owners can list their vehicles with details such as pricing and availability. On the driver side, drivers can view available vehicles, select a vehicle, and rent it through the application.

One of the major features I worked on was the driver onboarding and KYC process. I implemented a multi-step verification flow where drivers submit their required documents and a real-time selfie, which can then be reviewed and verified by the admin before the driver is allowed to rent vehicles.

The platform also follows a subscription-based model. Vehicle owners need an active subscription to list their vehicles on the platform.

So overall, my internship gave me practical experience in backend development, API design, authentication and verification flows, database handling, and implementing business requirements for a real-world application.



//3:You said you developed the backend. Can you explain what technologies you used and how you designed the backend architecture?

For the backend, I used Node.js with Express.js to develop the APIs and implement the business logic.

For the database, I used MongoDB because the application has different types of data and some fields can vary depending on the user or business requirement. MongoDB's flexible document structure made it convenient to work with this kind of data.

For authentication and authorization, I used JWT-based authentication. When a user logs in successfully, the server generates a JWT token, and the client sends that token with subsequent requests. Middleware verifies the token before allowing the request to access protected APIs.

I also implemented role-based access control, so different users have different permissions. For example, an admin can access the CRM and verify drivers, while an owner can manage their vehicles and a driver can search and rent available vehicles.

So the basic flow was:

**Client → API request → Authentication middleware → Authorization check → Controller/Business Logic → MongoDB → Response.**

I was mainly responsible for developing the backend APIs, implementing the business logic, and connecting the different application features with the database.


//4Suppose a driver logs in. Walk me through exactly what happens from the moment they enter their email and password until they receive a JWT token. Also tell me where the password is stored and how you verify it.

As I remember the implementation, the driver first logs in using their registered credentials. The backend verifies the credentials, and after successful authentication, a JWT token is generated and returned to the client.

For protected APIs, the client sends the JWT token with the request. Authentication middleware checks whether the token is valid and whether it has expired. After that, based on the user's role, the application checks whether that user is authorized to access the particular feature.

For example, a driver should be able to access driver-related features, while an admin has access to the CRM and verification features.

//kyc
For the KYC process, we divided the driver's onboarding into multiple steps.

First, the driver provides their basic information and then submits the required KYC details, including a selfie, driving license, national ID, and another required document.

On the backend, we stored the submitted information and documents against the driver's account and maintained the verification status. The important part was that the driver should not be able to use the rental functionality until the KYC process was successfully verified.

So the flow was basically: the driver submits the documents, the backend stores the information and marks the KYC as pending, and then the admin can review the submitted details from the CRM. If the admin verifies the documents, the driver's KYC status becomes verified. If there is an issue, it can remain pending or be rejected depending on the verification result.

Then, whenever the driver tries to access a protected rental feature, the backend can check the driver's authentication and KYC status before allowing the operation.

For example, the logic would be something like:

**Authenticated user → Check role → Check KYC status → If verified, allow rental operation → Otherwise, return an appropriate response.**

My main contribution was working on the backend APIs and business logic required for this onboarding and verification flow.


// recently reject in and interview
Here is the exact script you can use:

"Recently, I participated in an on-campus drive for a company called Airveda. The role was for a Python Full Stack Developer. At the time, my core expertise was heavily focused on Java, Node.js, and the MERN stack, so I didn't have much prior experience with Django.

I only had about two to three days before the interview, so I took the initiative to learn the basics of Python and Django and quickly built a small project using React for the frontend just to understand how the architecture connects.

During the technical round, they gave me two DSA questions. Because I am highly confident in my Java problem-solving skills, I chose to solve the problems in Java, and I successfully completed both of them. I also managed to answer their basic Django conceptual questions correctly based on what I had just learned.

Ultimately, their feedback was that while I had excellent logical skills and strong confidence in Java, the role strictly required deeper, more advanced Python expertise out of the gate. I wasn't selected, but I took that feedback very positively. In fact, it's the exact reason why I decided to deepen my Python skills recently by building my EdTech study abroad platform using Django.

Overall, that experience taught me how to adapt to new technologies under tight deadlines, but it also reinforced that my strongest foundational language is Java—which is why I am so excited about the technical stack here at CloudKaptan."



//"Describe your typical day."
I like to keep my days structured. I usually start my morning with a clear plan, dedicating the first couple of hours to practicing DSA in Java to keep my problem-solving skills sharp. By late morning and throughout the afternoon, my core focus shifts to my internship responsibilities, where I handle hands-on engineering tasks. After wrapping up my internship work, I usually spend a little time on my personal backend projects—like refining the APIs on my Django EdTech platform or testing routes in Postman. In the evening, I step away from the screen to get a workout in and spend time with my family, before reviewing my tasks for the next day.


//leadership skill
I got the opportunity to demonstrate leadership during my final-year project, SafeStree, where I worked with a team.

Since the project involved different parts like the frontend, backend, and AI-related features, we had to coordinate our work properly. I took responsibility for the backend and also helped coordinate with the other team members so that our different modules could work together.

Whenever someone was facing an issue, we discussed it together and tried to find a solution instead of working separately. I also made sure that my part was completed on time because if one module was delayed, it could affect the rest of the project.

I wouldn't say I was a formal team leader, but I did take ownership and help the team move forward. That experience taught me that leadership is not just about giving instructions; it's also about taking responsibility, communicating clearly, and supporting your teammates.


//4. "Why Kolkata? Do you have plans for higher education?"
Kolkata is my home, so I'm comfortable here and I would like to start my professional career here. My family is also here, so being in Kolkata gives me a good personal support system
Regarding higher education, I do have an interest in pursuing a master's degree in the future, particularly in the area of data science. But it is not my immediate plan. Right now, my priority is to start my professional career, gain practical industry experience, and become strong technically.

I believe working on real-world projects and learning from experienced professionals will give me a strong foundation. When I eventually decide to pursue higher education, I want that decision to be based on my experience and career goals rather than rushing into it immediately.
HR follow-up you should expect:

"So if you get an opportunity to study abroad next year, will you leave the company?"

A safe, honest response is:

"At the moment, higher education isn't my immediate plan. My focus is on starting my career and gaining industry experience. If my plans change significantly in the future, I would handle that professionally and communicate it properly, but right now I'm looking for a long-term opportunity where I can learn and contribute."

Yes, I may consider higher education in the future, but it is not my immediate priority. Right now, my focus is to start my career, gain practical industry experience, and build strong technical skills. I want to spend the next few years learning, contributing to real projects, and understanding where I want to specialize before making that decision.

//why kolkata
Kolkata is my hometown, so I'm comfortable with the city and familiar with the environment here. My family is also here, so being in Kolkata gives me a good support system.

At the same time, my main priority is not just the location. I'm looking for a good opportunity where I can learn, work on real projects, and grow professionally. So if I get that opportunity in Kolkata, I'm happy to build my career here.

//"Why do you want to join CloudKaptan? Why not a large MNC?

I don't see it as choosing CloudKaptan over an MNC. At the beginning of my career, my main priority is learning, getting hands-on experience, and taking real responsibility.

From my internship and projects, I've realized that I enjoy working closely with the product and understanding how different parts of a software application come together. I want an environment where I can work on real problems, interact with experienced people, and see the impact of the work I'm doing.

That's why CloudKaptan interests me. I feel that an organization where I can get practical exposure and gradually take more ownership would be a good environment for me to start my career.

I have nothing against large MNCs. They have their own advantages, but for my first role, I'm more focused on the quality of learning, responsibility, and the kind of work I'll be doing rather than simply the size or brand of the company.

