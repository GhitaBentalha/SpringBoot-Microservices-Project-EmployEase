// Exemple : Récupérer les offres d'emploi
async function fetchJobs() {
    try {
        const response = await fetch('http://localhost:8080/api/jobs');
        const jobs = await response.json();
        const jobList = document.getElementById('job-list');
        jobList.innerHTML = jobs.map(job => `
            <div class="job">
                <h3>${job.title}</h3>
                <p>${job.description}</p>
            </div>
        `).join('');
    } catch (error) {
        console.error('Erreur lors de la récupération des offres d\'emploi :', error);
    }
}

// Exemple : Récupérer les entreprises
async function fetchCompanies() {
    try {
        const response = await fetch('http://localhost:8080/api/companies');
        const companies = await response.json();
        const companyList = document.getElementById('company-list');
        companyList.innerHTML = companies.map(company => `
            <div class="company">
                <h3>${company.name}</h3>
                <p>${company.description}</p>
            </div>
        `).join('');
    } catch (error) {
        console.error('Erreur lors de la récupération des entreprises :', error);
    }
}

// Exemple : Récupérer les avis
async function fetchReviews() {
    try {
        const response = await fetch('http://localhost:8080/api/reviews');
        const reviews = await response.json();
        const reviewList = document.getElementById('review-list');
        reviewList.innerHTML = reviews.map(review => `
            <div class="review">
                <h3>${review.title}</h3>
                <p>${review.content}</p>
            </div>
        `).join('');
    } catch (error) {
        console.error('Erreur lors de la récupération des avis :', error);
    }
}

// Exemple : Gestion de la connexion
document.getElementById('login-form').addEventListener('submit', async (e) => {
    e.preventDefault();
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    try {
        const response = await fetch('http://localhost:8080/auth/signin', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ email, password }),
            credentials: 'include' // Activer les cookies
        });

        if (!response.ok) {
            throw new Error('Erreur lors de la connexion');
        }

        const data = await response.json();
        alert('Connexion réussie !');
        console.log('Données de l\'utilisateur :', data);
    } catch (error) {
        console.error('Erreur :', error);
        alert('Erreur de connexion : ' + error.message);
    }
});

// Charger les données au démarrage
fetchJobs();
fetchCompanies();
fetchReviews();
