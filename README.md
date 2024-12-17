# MajesticCup API - Football Cup Management

## ⚽ Quick Description
MajesticCup is a secure REST API for managing knockout football competitions. Built with **Spring Boot** and **MongoDB**, the API simplifies organizing cups, managing teams and players, and tracking real-time statistics. Security is ensured via **JWT** for authentication and a role-based system for authorizations.

---

## 📊 Key Features
### ✏️ **Team Management**
- Add, edit, and delete teams.
- Manage players associated with each team.

### 🏆 **Competition Organization**
- Create and manage competitions.
- Automated match draw.
- Round management based on match results.

### 🔄 **Results and Statistics Tracking**
- Record match results (goals, assists, cards).
- Public access to leaderboards:
  - Top Scorers
  - Top Assists
  - Players with Cards (yellow/red)

### 🛡️ **Advanced Security**
- Authentication with **JWT**.
- Role management (ADMIN, OPERATOR).
- Protection of sensitive endpoints using **Spring Security**.

---

## 📂 MongoDB Collections Architecture
### **1. Team (teams)**
```json
{
  "_id": "ObjectId",
  "name": "string",
  "city": "string",
  "players": [
    {
      "id": "ObjectId",
      "name": "string",
      "surname": "string",
      "position": "string",
      "number": "int"
    }
  ]
}
```

### **2. Match (matches)**
```json
{
  "_id": "ObjectId",
  "round": "int",
  "team1": "ObjectId",
  "team2": "ObjectId",
  "result": {
    "team1Goals": "int",
    "team2Goals": "int",
    "statistics": [
      {
        "playerId": "ObjectId",
        "goals": "int",
        "assists": "int",
        "yellowCards": "int",
        "redCards": "int"
      }
    ]
  },
  "winner": "ObjectId"
}
```

### **3. Competition (competitions)**
```json
{
  "_id": "ObjectId",
  "name": "string",
  "numberOfTeams": "int",
  "teams": ["ObjectId"],
  "currentRound": "int",
  "rounds": ["ObjectId"]
}
```

### **4. User (users)**
```json
{
  "_id": "ObjectId",
  "username": "string",
  "password": "string",
  "roles": "string"
}
```

### **5. Round (rounds)**
```json
{
  "_id": "ObjectId",
  "roundNumber": "int",
  "competitionId": "ObjectId",
  "matches": [
    {
      "matchId": "ObjectId",
      "team1": "ObjectId",
      "team2": "ObjectId",
      "result": {
        "team1Goals": "int",
        "team2Goals": "int",
        "statistics": [
          {
            "playerId": "ObjectId",
            "goals": "int",
            "assists": "int",
            "yellowCards": "int",
            "redCards": "int"
          }
        ]
      },
      "winner": "ObjectId"
    }
  ]
}
```

---

## 🔒 Security Management with JWT
### **Roles**
- **ADMIN**:
  - Manage competitions, teams, players, and results.
  - Access to admin endpoints.
- **OPERATOR**:
  - Record match results.
- **Public Endpoints**:
  - Access without authentication for statistics and results.

### **Spring Security**
- **JwtAuthenticationFilter**: Validates JWT tokens.
- **Endpoint Protection**:
  - `/admin/**`: Role **ADMIN**.
  - `/operator/**`: Role **OPERATOR**.
  - **Public endpoints**: Free access.

---

## 🛠️ Example REST Endpoints
### **Admin API (ADMIN Role)**
- `POST /api/admin/teams`: Add a team.
- `POST /api/admin/competitions`: Create a new competition.

### **Operator API (OPERATOR Role)**
- `POST /api/operator/matches/results`: Record match results.

### **Public API (Free Access)**
- `GET /api/public/results`: View match results.
- `GET /api/public/statistics/top-scorers`: Top scorers leaderboard.
- `GET /api/public/statistics/top-assists`: Top assists leaderboard.
- `GET /api/public/statistics/cards`: Card leaderboard.

---

## 🛣️ Technologies Used
- **Spring Boot**: Java backend framework.
- **MongoDB**: NoSQL database for data storage.
- **Spring Security**: Security and authorization management.
- **JWT**: Secure authentication tokens.
- **YAML**: Simple and readable configuration.

---

## 💡 Run the Project
1. **Clone the repository**:
   ```bash
   git clone https://github.com/hariti-asm/majesticcup-api.git
   cd majesticcup-api
   ```

2. **Configure MongoDB**:
   - Ensure MongoDB is installed and running.
   - Edit the `application.yml` file to add your MongoDB details.

3. **Start the application**:
   ```bash
   mvn spring-boot:run
   ```

4. **Access the API**:
   - The API will be available at `http://localhost:8083`.

---

## 🔧 Contribute
1. Fork the repository.
2. Create a branch:
   ```bash
   git checkout -b my-feature
   ```
3. Submit a Pull Request.

---

## 📜 License
This project is licensed under the **MIT** License. You are free to use it.


