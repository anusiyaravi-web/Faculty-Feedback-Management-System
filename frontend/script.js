
const questions = [
    "Faculty comes to class on time",
    "Faculty explains concepts clearly",
    "Faculty encourages questions",
    "Faculty uses teaching aids effectively",
    "Faculty maintains discipline",
    "Faculty covers syllabus completely",
    "Faculty provides notes/materials",
    "Faculty motivates students",
    "Faculty conducts assessments fairly",
    "Overall teaching effectiveness"
];

// Display the 10 feedback questions
const questionsDiv = document.getElementById("questions");

questions.forEach((question, index) => {
    questionsDiv.innerHTML += `
        <div class="question">
            <label>${index + 1}. ${question}</label>

            <select id="q${index + 1}" required>
                <option value="5">Excellent</option>
                <option value="4">Good</option>
                <option value="3">Average</option>
                <option value="2">Poor</option>
                <option value="1">Very Poor</option>
            </select>
        </div>
    `;
});

// Submit feedback to the Spring Boot backend
document.getElementById("feedbackForm")
    .addEventListener("submit", async function (e) {

        e.preventDefault();

        const studentName =
            document.getElementById("studentName").value.trim();

        const registerNumber =
            document.getElementById("registerNumber").value.trim();

        const facultyName =
            document.getElementById("facultyName").value;

        // Validate student details
        if (!studentName || !registerNumber || !facultyName) {
            alert("Please enter all student details and select a faculty.");
            return;
        }

        // Collect student details
        const feedback = {
            studentName: studentName,
            registerNumber: registerNumber,
            facultyName: facultyName
        };

        // Collect all 10 ratings
        for (let i = 1; i <= 10; i++) {
            feedback["q" + i] = Number(
                document.getElementById("q" + i).value
            );
        }

        // Send feedback to Spring Boot
        try {
            const response = await fetch(
                "http://localhost:8080/api/feedback",
                {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify(feedback)
                }
            );

            const result = await response.json();

            if (!response.ok) {
                throw new Error(
                    result.message || "Failed to save feedback."
                );
            }

            alert("Feedback submitted successfully!");

            document.getElementById("feedbackForm").reset();

        } catch (error) {
            console.error("Feedback submission error:", error);

            alert(
                "Feedback could not be saved. " +
                "Check the backend, MySQL connection, and database table."
            );
        }
    });
