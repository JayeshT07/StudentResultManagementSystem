const auth = "Basic " + btoa("admin:admin123");

async function api(url, options = {}) {
    options.headers = {
        ...(options.headers || {}),
        "Authorization": auth,
        "Content-Type": "application/json"
    };
    const response = await fetch(url, options);
    if (!response.ok) throw new Error(await response.text());
    return response.status === 204 ? null : response.json();
}

async function loadStudents() {
    try {
        const students = await api("/api/students");
        document.getElementById("students").innerHTML = students.map(s => `
            <tr>
                <td>${s.id}</td>
                <td>${s.rollNumber}</td>
                <td>${s.firstName} ${s.lastName}</td>
                <td>${s.email}</td>
                <td>${s.semester}</td>
                <td>${s.department || ""}</td>
            </tr>
        `).join("");
    } catch (e) {
        alert("Could not load students. Make sure MySQL and the application are running.");
    }
}

document.getElementById("studentForm").addEventListener("submit", async e => {
    e.preventDefault();
    const data = Object.fromEntries(new FormData(e.target).entries());
    data.semester = Number(data.semester);

    try {
        await api("/api/students", {
            method: "POST",
            body: JSON.stringify(data)
        });
        e.target.reset();
        await loadStudents();
        alert("Student saved.");
    } catch (error) {
        alert("Could not save student: " + error.message);
    }
});

loadStudents();
