// menu a tendina con i dati provenienti dai controller
async function populateSelect(url, selectElement) {
	try {
		const response = await fetch(url);
		if (!response.ok) throw new Error("Errore nel caricamento dei dati");

		const data = await response.json();
		selectElement.innerHTML = `<option value="">Seleziona</option>`;

		data.forEach(item => {
			const option = document.createElement("option"); //cambiare id con name
			option.value = item.name || item.departmentName || item.city || item.countryName || item.regionName;
			   option.text = item.name || item.departmentName || item.city || item.countryName || item.regionName;
			selectElement.appendChild(option);
		});
	} catch (error) {
		console.error("Errore:", error);
	}
}

// Tendine
document.addEventListener("DOMContentLoaded", function() {
	populateSelect("/api/departments", document.getElementById("departmentName"));
	populateSelect("/api/locations", document.getElementById("city"));
	populateSelect("/api/countries", document.getElementById("countryName"));
	populateSelect("/api/regions", document.getElementById("regionName"));
});

// Tasto Search
document.getElementById("searchForm").addEventListener("submit", async function(event) {
	event.preventDefault();

	const formData = new FormData(event.target);
	const params = new URLSearchParams();

	formData.forEach((value, key) => {
		if (value) { // Aggiunge solo i campi valorizzati
			params.append(key, value);
		}
	});

	// Invia la richiesta di ricerca al backend
	try {
		const response = await fetch(`/api/employees/search?${params.toString()}`); //toString per i parametri non in input
		if (!response.ok) throw new Error("Errore nella ricerca dei dati");

		const results = await response.json();

		// Popola la tabella
		const resultsBody = document.getElementById("resultsBody");
		resultsBody.innerHTML = ""; // Pulisce i risultati di prima

		if (results.length === 0) {
			resultsBody.innerHTML = `<tr><td colspan="7">Nessun dipendente trovato</td></tr>`;
			return;
		}

		// Tabella dei risultati
		results.forEach(employee => {
			const row = document.createElement("tr");
			row.innerHTML = `
                <td>${employee.firstName}</td>
                <td>${employee.lastName}</td>
                <td>${employee.salary}</td>
                <td>${employee.department?.departmentName || ''}</td>
                <td>${employee.department?.location?.city || ''}</td>
				<td>${employee.department?.location?.country?.countryName || ''}</td>
				<td>${employee.department?.location?.country?.region?.regionName || ''}</td>
            `;
			resultsBody.appendChild(row);
		});
	} catch (error) {
		console.error("Errore:", error);
		const resultsBody = document.getElementById("resultsBody");
		resultsBody.innerHTML = `<tr><td colspan="7">Errore durante la ricerca</td></tr>`; //errore 400
	}
});


