var autoInfos = [
  {
    id: "bmw116d",
    model: "bmw 116d",
    year: 2015,
    color: "white",
    serviceRecords: [
      {
        id: "bmw116d_1",
        date: "20.07.2019",
        km: "13000",
        price: 900,
        detail: [
          {
            id: "bmw116d_1_1",
            comment: "change oil",
            price: 300,
          },
          {
            id: "bmw116d_1_2",
            comment: "change filter",
            price: 300,
          },
          {
            id: "bmw116d_1_3",
            comment: "brake hydraulic oil",
            price: 300,
          },
        ],
      },
      {
        id: "bmw116d_2",
        date: "22.06.2020",
        km: "28000",
        price: 1800,
        detail: [
          {
            id: "bmw116d_2_1",
            comment: "change oil",
            price: 350,
          },
          {
            id: "bmw116d_2_2",
            comment: "change filter",
            price: 350,
          },
          {
            id: "bmw116d_2_3",
            comment: "brake hydraulic oil",
            price: 300,
          },
          {
            id: "bmw116d_2_4",
            comment: "brake lining",
            price: 800,
          },
        ],
      },
    ],
  },
  {
    id: "bmw118i",
    model: "bmw 118i",
    year: 2015,
    color: "white",
    serviceRecords: [
      {
        id: "bmw118i_1",
        date: "20.07.2019",
        km: "13000",
        price: 900,
        detail: [
          {
            id: "bmw118i_1_1",
            comment: "change oil",
            price: 300,
          },
          {
            id: "bmw118i_1_2",
            comment: "change filter",
            price: 300,
          },
          {
            id: "bmw118i_1_3",
            comment: "brake hydraulic oil",
            price: 300,
          },
        ],
      },
      {
        id: "bmw118i_2",
        date: "22.06.2020",
        km: "28000",
        price: 1800,
        detail: [
          {
            id: "bmw118i_2_1",
            comment: "change oil",
            price: 350,
          },
          {
            id: "bmw118i_2_2",
            comment: "change filter",
            price: 350,
          },
          {
            id: "bmw118i_2_3",
            comment: "brake hydraulic oil",
            price: 300,
          },
          {
            id: "bmw118i_2_4",
            comment: "brake lining",
            price: 800,
          },
        ],
      },
    ],
  },
  {
    id: "bmw320d",
    model: "bmw 320d",
    year: 2015,
    color: "white",
    serviceRecords: [
      {
        id: "bmw320d_1",
        date: "20.07.2019",
        km: "13000",
        price: 900,
        detail: [
          {
            id: "bmw320d_1_1",
            comment: "change oil",
            price: 300,
          },
          {
            id: "bmw320d_1_2",
            comment: "change filter",
            price: 300,
          },
          {
            id: "bmw320d_1_3",
            comment: "brake hydraulic oil",
            price: 300,
          },
        ],
      },
      {
        id: "bmw320d_2",
        date: "22.06.2020",
        km: "28000",
        price: 1800,
        detail: [
          {
            id: "bmw320d_2_1",
            comment: "change oil",
            price: 350,
          },
          {
            id: "bmw320d_2_2",
            comment: "change filter",
            price: 350,
          },
          {
            id: "bmw320d_2_3",
            comment: "brake hydraulic oil",
            price: 300,
          },
          {
            id: "bmw320d_2_4",
            comment: "brake lining",
            price: 800,
          },
        ],
      },
    ],
  },
];

console.log(autoInfos[0]);
console.log(autoInfos[0].id);
console.log(autoInfos[0].model);
console.log(autoInfos[0].color);
console.log(autoInfos[0].serviceRecords);
console.log(autoInfos[0].serviceRecords[0]);
console.log(autoInfos[0].serviceRecords[0].km);
console.log(autoInfos[0].serviceRecords[0].price);
console.log(autoInfos[0].serviceRecords[0].detail);
console.log(autoInfos[0].serviceRecords[0].detail[0]);
console.log(autoInfos[0].serviceRecords[0].detail[0].price);
console.log(autoInfos[0].serviceRecords[1].km);
console.log(autoInfos[0].serviceRecords[1].price);
console.log(autoInfos[0].serviceRecords[1].detail);
console.log(autoInfos[0].serviceRecords[1].detail[0]);
console.log(autoInfos[0].serviceRecords[1].detail[0].price);


console.log(autoInfos[1]);
console.log(autoInfos[2]);


