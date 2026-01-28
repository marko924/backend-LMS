# backend-LMS

# Podela posla

U nastavku je prikazana podela zadataka između Marka i Stefana, sa ciljem da se smanji broj Git konflikata i preklapanja u radu.

## 📋 Tabela podele posla

| Član tima  | Oblast rada                                  | Zaduženja                                                                                                                                                                                                                                                                                               |
| ---------- | -------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Stefan** | Autentifikacija i studentske funkcionalnosti | - Registracija korisnika (bcrypt, JWT, auth middleware)<br>- Prijava korisnika (login)<br>- Prijava ispita<br>- Pregled ostvarenih rezultata studenta<br>- Zaštita ruta (role: student, profesor, služba)<br>- Backend logika za korisnike                                                              |
| **Marko**  | Administracija i javni sadržaj               | - Upis studenata na godinu/fakultet/program<br>- Zakazivanje ispitnih rokova i ispita<br>- Unos ocena (profesor)<br>- Stranica univerziteta (podaci o univerzitetu)<br>- Stranice fakulteta<br>- Studijski programi i predmeti<br>- Silabusi i nastavni materijali<br>- Frontend prikaz javnog sadržaja |

---

## 🛠️ Preporučeni način rada sa Git-om

Da bi se izbegli konflikti:

### 1. Razdvajanje po modulima

* Stefan radi u folderima vezanim za `auth`, `users`, `student`.
* Marko radi u folderima vezanim za `admin`, `university`, `faculty`, `subjects`.

### 2. Rad na posebnim granama

Svaki član radi na svojoj grani:

```bash
# Stefan
git switch -c feature-auth-student

# Marko
git switch -c feature-admin-public
```

### 3. Redovno spajanje sa main granom

Pre većih izmena:

```bash
git switch main
git pull
```

Zatim se vraćate na svoju granu i merge-ujete:

```bash
git merge main
```

### 4. Jasni commit opisi

Primer:

```bash
git commit -m "Implementirana prijava ispita"
```

---

Ako se budete držali ove podele, rizik od konflikata će biti minimalan, a razvoj brži i pregledniji.
