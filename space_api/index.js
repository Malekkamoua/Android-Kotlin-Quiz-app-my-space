const express = require("express");
const app = express();
const port = 3000;

app.get("/", (req, res) => {
  planets_array = [
    {
      title: "Mercure",
      description:
        "est la planète la plus proche du Soleil, ainsi que la plus petite (4 878 km de diamètre) et la moins massive avec un peu plus du vingtième de la masse terrestre."
    },
    {
      title: "Venus",
      description:
        "est la planète la plus proche de la Terre en taille (0,95 rayon terrestre) et en masse (0,815 masse terrestre), faisant qu'elle est parfois appelée sa «planète sœur ». Comme elle, Vénus possède également un épais manteau de silicate entourant un noyau métallique, une atmosphère significative et une activité géologique interne."
    },
    {
      title: "Mars",
      description:
        "est deux fois plus petite que la Terre et Vénus, et fait seulement environ le dixième de la masse terrestre. Sa période de révolution autour du Soleil est de 687 jours terrestres et sa journée dure 24 heures et 39 minutes."
    },
    {
      title: "Jupiter",
      description:
        "avec 318 masses terrestres, est aussi massive que 2,5 fois toutes les autres planètes réunies et son diamètre avoisine les 143 000 kilomètres. Sa période de révolution est d'environ 12 ans et sa période de rotation est d'un peu moins de 10 heures."
    },
    {
      title: "Saturne",
      description:
        "possède des caractéristiques similaires à Jupiter, telles que sa composition atmosphérique et sa puissante magnétosphère. Bien qu'elle fasse 60 % du volume de l'autre planète géante gazeuse du fait de son diamètre équatorial d'environ 121 000 kilomètres, elle est beaucoup moins massive avec 95 masses terrestres."
    },
    {
      title: "Uranus",
      description:
        "est la moins massive des planètes géantes avec 14 masses terrestres. Avec son diamètre d'environ 51 000 kilomètres, elle demeure plus grande que sa presque jumelle Neptune en raison de la compression gravitationnelle de cette dernière."
    },
    {
      title: "Neptune",
      description:
        "est la planète la plus éloignée du Soleil connue au sein du Système solaire. Légèrement plus massive qu'Uranus avec 17 masses terrestres, elle est par conséquent plus dense avec un diamètre équatorial d'environ 49 500 kilomètres par compression gravitationnelle"
    },
    {
      title: "Pluton",
      description:
        "a perdu son statut de neuvième planète du Système solaire. A la suite d’un vote de l’Union astronomique internationale, elle s’est vue rétrogradée en planète naine. La raison principale de ce changement d’appellation provient d’une redéfinition de ce qu’est une planète"
    }
  ];
  res.send(planets_array);
});
app.listen(process.env.PORT || port, () =>
  console.log(`Example app listening at http://localhost:${port}`)
);
