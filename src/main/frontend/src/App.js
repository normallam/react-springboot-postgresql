
/*
src/main/frontend/src/App.js
import React, {useEffect, useState} from 'react';
import axios from 'axios';

function App() {
   const [hello, setHello] = useState('')

    useEffect(() => {
        axios.get('/api/hello')
        .then(response => setHello(response.data))
        .catch(error => console.log(error))
    }, []);

    return (
        <div>
            백엔드에서 가져온 데이터입니다 : {hello}
        </div>
    );
}

export default App;
*/

import React, { useState } from 'react';
import axios from 'axios';

const App = () => {
    const [name, setName] = useState('');
    const [description, setDescription] = useState('');
    const [startDate, setStartDate] = useState('');
    const [endDate, setEndDate] = useState('');
    const [budget, setBudget] = useState('');
    const [teamMembers, setTeamMembers] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            //  teamMembers를 JSON 형식으로 파싱하여 전송
            const parsedTeamMembers = JSON.parse(teamMembers);

            const response = await axios.post('http://localhost:8080/api/tests', {
                name,
                description,
                start_date: startDate,
                end_date: endDate,
                budget,
                team_members: parsedTeamMembers,  // JSON 데이터 전송
            });
            console.log(response.data);
        } catch (error) {
            console.error('Error saving data:', error);
        }
    };

    return (
            <form onSubmit={handleSubmit}>
                <input type="text" value={name} onChange={(e) => setName(e.target.value)} placeholder="Project Name" required />
                <textarea value={description} onChange={(e) => setDescription(e.target.value)} placeholder="Description" />
                <input type="date" value={startDate} onChange={(e) => setStartDate(e.target.value)} placeholder="Start Date" />
                <input type="date" value={endDate} onChange={(e) => setEndDate(e.target.value)} placeholder="End Date" />
                <input type="number" value={budget} onChange={(e) => setBudget(e.target.value)} placeholder="Budget" />
                <textarea value={teamMembers} onChange={(e) => setTeamMembers(e.target.value)} placeholder="Team Members (JSON format)" />
                <button type="submit">Submit</button>
            </form>
        );
};

export default App;
