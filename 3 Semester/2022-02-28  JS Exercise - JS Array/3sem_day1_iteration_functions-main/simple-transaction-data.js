const data = [
  {
    "credit_card_company": "VISA",
    "transaction_date": "2018-09-07T14:43:15.792+02:00",
    "price": "90",
    "category": "Home"
  },
  {
    "credit_card_company": "Discover",
    "transaction_date": "2017-05-05T07:43:35.169+02:00",
    "price": "92.99",
    "category": "Home"
  },
  {
    "credit_card_company": "Discover",
    "transaction_date": "2017-02-22T13:39:18.049+01:00",
    "price": "121.99",
    "category": "Activity"
  },
  {
    "credit_card_company": "American Express",
    "transaction_date": "2012-07-09T12:41:30.143+02:00",
    "price": "114.99",
    "category": "Automotive"
  },
  {
    "credit_card_company": "MasterCard",
    "transaction_date": "2015-06-03T08:40:27.389+02:00",
    "price": "79.99",
    "category": "Activity"
  },
  {
    "credit_card_company": "Discover",
    "transaction_date": "2014-02-23T16:47:18.801+01:00",
    "price": "86.99",
    "category": "Activity"
  },
  {
    "credit_card_company": "American Express",
    "transaction_date": "2018-10-13T15:38:29.884+02:00",
    "price": "164.99",
    "category": "Activity"
  },
  {
    "credit_card_company": "Discover",
    "transaction_date": "2014-01-05T01:06:03.679+01:00",
    "price": "194.99",
    "category": "Automotive"
  },
  {
    "credit_card_company": "American Express",
    "transaction_date": "2021-09-05T20:30:54.403+02:00",
    "price": "140.99",
    "category": "Beauty"
  },
  {
    "credit_card_company": "Discover",
    "transaction_date": "2014-05-14T00:27:16.379+02:00",
    "price": "84",
    "category": "Clothing"
  },
  {
    "credit_card_company": "Discover",
    "transaction_date": "2011-06-22T18:47:34.112+02:00",
    "price": "16.95",
    "category": "Clothing"
  },
  {
    "credit_card_company": "Discover",
    "transaction_date": "2015-10-05T17:21:16.888+02:00",
    "price": "53.99",
    "category": "Home"
  },
  {
    "credit_card_company": "VISA",
    "transaction_date": "2015-01-28T15:29:13.469+01:00",
    "price": "145.99",
    "category": "Home"
  },
  {
    "credit_card_company": "American Express",
    "transaction_date": "2019-06-17T06:32:35.925+02:00",
    "price": "123",
    "category": "Beauty"
  },
  {
    "credit_card_company": "Discover",
    "transaction_date": "2011-03-25T23:06:56.827+01:00",
    "price": "109",
    "category": "Beauty"
  },
  {
    "credit_card_company": "VISA",
    "transaction_date": "2013-02-07T01:52:20.860+01:00",
    "price": "177.95",
    "category": "Home"
  },
  {
    "credit_card_company": "VISA",
    "transaction_date": "2010-04-20T12:44:46.583+02:00",
    "price": "64.95",
    "category": "Entertainment"
  },
  {
    "credit_card_company": "MasterCard",
    "transaction_date": "2016-07-27T10:21:36.355+02:00",
    "price": "173.99",
    "category": "Pets"
  },
  {
    "credit_card_company": "VISA",
    "transaction_date": "2017-12-27T20:48:48.375+01:00",
    "price": "77.99",
    "category": "Home"
  },
  {
    "credit_card_company": "American Express",
    "transaction_date": "2016-04-15T10:30:17.901+02:00",
    "price": "48.99",
    "category": "Home"
  },
  {
    "credit_card_company": "Discover",
    "transaction_date": "2019-10-27T19:29:58.747+01:00",
    "price": "106.95",
    "category": "Electronics"
  },
  {
    "credit_card_company": "VISA",
    "transaction_date": "2015-12-22T22:28:07.551+01:00",
    "price": "180.95",
    "category": "Electronics"
  },
  {
    "credit_card_company": "MasterCard",
    "transaction_date": "2013-03-02T14:39:04.179+01:00",
    "price": "35.95",
    "category": "Pets"
  },
  {
    "credit_card_company": "MasterCard",
    "transaction_date": "2015-01-22T15:58:28.511+01:00",
    "price": "95.99",
    "category": "Activity"
  },
  {
    "credit_card_company": "American Express",
    "transaction_date": "2019-08-20T19:20:58.466+02:00",
    "price": "73.99",
    "category": "Activity"
  },
  {
    "credit_card_company": "American Express",
    "transaction_date": "2013-08-04T23:34:47.421+02:00",
    "price": "54.99",
    "category": "Activity"
  },
  {
    "credit_card_company": "VISA",
    "transaction_date": "2020-05-22T18:25:28.448+02:00",
    "price": "137.95",
    "category": "Clothing"
  },
  {
    "credit_card_company": "MasterCard",
    "transaction_date": "2015-03-17T17:00:26.836+01:00",
    "price": "136.99",
    "category": "Entertainment"
  },
  {
    "credit_card_company": "American Express",
    "transaction_date": "2015-01-13T22:51:06.043+01:00",
    "price": "131.95",
    "category": "Beauty"
  },
  {
    "credit_card_company": "MasterCard",
    "transaction_date": "2015-05-15T04:31:01.431+02:00",
    "price": "54",
    "category": "Clothing"
  },
  {
    "credit_card_company": "MasterCard",
    "transaction_date": "2010-04-17T11:40:39.527+02:00",
    "price": "182.99",
    "category": "Electronics"
  },
  {
    "credit_card_company": "MasterCard",
    "transaction_date": "2018-02-26T12:49:19.194+01:00",
    "price": "102.95",
    "category": "Electronics"
  },
  {
    "credit_card_company": "Discover",
    "transaction_date": "2015-09-17T09:38:15.401+02:00",
    "price": "43.95",
    "category": "Activity"
  },
  {
    "credit_card_company": "MasterCard",
    "transaction_date": "2020-12-24T22:57:50.352+01:00",
    "price": "14.99",
    "category": "Activity"
  },
  {
    "credit_card_company": "American Express",
    "transaction_date": "2012-11-08T16:40:20.952+01:00",
    "price": "40",
    "category": "Clothing"
  },
  {
    "credit_card_company": "VISA",
    "transaction_date": "2017-01-29T06:24:55.797+01:00",
    "price": "178.99",
    "category": "Home"
  },
  {
    "credit_card_company": "American Express",
    "transaction_date": "2021-08-13T06:03:04.449+02:00",
    "price": "131.99",
    "category": "Pets"
  },
  {
    "credit_card_company": "MasterCard",
    "transaction_date": "2015-04-20T17:04:42.173+02:00",
    "price": "88.95",
    "category": "Home"
  },
  {
    "credit_card_company": "MasterCard",
    "transaction_date": "2016-09-14T16:08:46.708+02:00",
    "price": "54.99",
    "category": "Home"
  },
  {
    "credit_card_company": "VISA",
    "transaction_date": "2017-07-22T01:28:29.698+02:00",
    "price": "47",
    "category": "Automotive"
  },
  {
    "credit_card_company": "MasterCard",
    "transaction_date": "2011-03-02T01:10:20.530+01:00",
    "price": "107.95",
    "category": "Electronics"
  },
  {
    "credit_card_company": "VISA",
    "transaction_date": "2013-08-06T15:31:46.223+02:00",
    "price": "178",
    "category": "Home"
  },
  {
    "credit_card_company": "Discover",
    "transaction_date": "2021-03-08T06:06:27.727+01:00",
    "price": "101",
    "category": "Home"
  },
  {
    "credit_card_company": "VISA",
    "transaction_date": "2013-12-14T21:33:47.828+01:00",
    "price": "49.99",
    "category": "Clothing"
  },
  {
    "credit_card_company": "VISA",
    "transaction_date": "2012-07-24T07:03:49.690+02:00",
    "price": "103",
    "category": "Pets"
  },
  {
    "credit_card_company": "VISA",
    "transaction_date": "2011-11-05T12:32:09.104+01:00",
    "price": "29.99",
    "category": "Activity"
  },
  {
    "credit_card_company": "Discover",
    "transaction_date": "2016-02-19T07:43:38.679+01:00",
    "price": "130.99",
    "category": "Home"
  },
  {
    "credit_card_company": "American Express",
    "transaction_date": "2020-09-10T08:04:15.486+02:00",
    "price": "27.99",
    "category": "Automotive"
  },
  {
    "credit_card_company": "American Express",
    "transaction_date": "2020-08-10T22:34:34.483+02:00",
    "price": "47.99",
    "category": "Clothing"
  },
  {
    "credit_card_company": "Discover",
    "transaction_date": "2012-10-26T04:39:29.330+02:00",
    "price": "35",
    "category": "Beauty"
  },
  {
    "credit_card_company": "VISA",
    "transaction_date": "2014-08-04T10:58:59.918+02:00",
    "price": "18.95",
    "category": "Automotive"
  },
  {
    "credit_card_company": "American Express",
    "transaction_date": "2012-10-10T19:20:05.224+02:00",
    "price": "36.99",
    "category": "Beauty"
  },
  {
    "credit_card_company": "American Express",
    "transaction_date": "2020-11-08T06:25:31.142+01:00",
    "price": "68.99",
    "category": "Health"
  },
  {
    "credit_card_company": "VISA",
    "transaction_date": "2019-03-14T13:10:13.415+01:00",
    "price": "88",
    "category": "Entertainment"
  },
  {
    "credit_card_company": "American Express",
    "transaction_date": "2021-04-03T08:45:05.338+02:00",
    "price": "144.95",
    "category": "Beauty"
  },
  {
    "credit_card_company": "VISA",
    "transaction_date": "2019-12-15T07:21:00.627+01:00",
    "price": "107",
    "category": "Activity"
  },
  {
    "credit_card_company": "Discover",
    "transaction_date": "2013-11-27T20:35:57.544+01:00",
    "price": "61.95",
    "category": "Home"
  },
  {
    "credit_card_company": "MasterCard",
    "transaction_date": "2014-03-01T12:31:18.609+01:00",
    "price": "144.95",
    "category": "Entertainment"
  },
  {
    "credit_card_company": "Discover",
    "transaction_date": "2011-02-21T11:05:23.863+01:00",
    "price": "190.99",
    "category": "Home"
  },
  {
    "credit_card_company": "Discover",
    "transaction_date": "2016-08-26T08:07:51.422+02:00",
    "price": "199",
    "category": "Beauty"
  },
  {
    "credit_card_company": "American Express",
    "transaction_date": "2018-10-02T10:45:43.265+02:00",
    "price": "20.99",
    "category": "Entertainment"
  },
  {
    "credit_card_company": "MasterCard",
    "transaction_date": "2013-06-28T17:21:11.090+02:00",
    "price": "17",
    "category": "Entertainment"
  },
  {
    "credit_card_company": "MasterCard",
    "transaction_date": "2012-08-31T23:52:37.818+02:00",
    "price": "194.95",
    "category": "Home"
  },
  {
    "credit_card_company": "Discover",
    "transaction_date": "2014-08-13T14:54:06.174+02:00",
    "price": "129.99",
    "category": "Beauty"
  },
  {
    "credit_card_company": "MasterCard",
    "transaction_date": "2011-06-30T19:55:45.821+02:00",
    "price": "58.99",
    "category": "Clothing"
  },
  {
    "credit_card_company": "VISA",
    "transaction_date": "2017-12-11T21:40:34.831+01:00",
    "price": "82.95",
    "category": "Health"
  },
  {
    "credit_card_company": "Discover",
    "transaction_date": "2012-11-13T00:10:21.247+01:00",
    "price": "181",
    "category": "Home"
  },
  {
    "credit_card_company": "VISA",
    "transaction_date": "2020-09-14T06:32:24.506+02:00",
    "price": "166.99",
    "category": "Pets"
  },
  {
    "credit_card_company": "VISA",
    "transaction_date": "2021-09-12T21:48:15.216+02:00",
    "price": "115.95",
    "category": "Home"
  },
  {
    "credit_card_company": "Discover",
    "transaction_date": "2013-01-31T20:10:06.126+01:00",
    "price": "64.99",
    "category": "Electronics"
  },
  {
    "credit_card_company": "Discover",
    "transaction_date": "2012-09-18T13:36:30.996+02:00",
    "price": "117.99",
    "category": "Beauty"
  },
  {
    "credit_card_company": "American Express",
    "transaction_date": "2015-12-10T15:43:55.687+01:00",
    "price": "138.99",
    "category": "Activity"
  },
  {
    "credit_card_company": "American Express",
    "transaction_date": "2015-03-05T18:26:32.480+01:00",
    "price": "184.95",
    "category": "Entertainment"
  },
  {
    "credit_card_company": "VISA",
    "transaction_date": "2018-05-31T11:22:35.490+02:00",
    "price": "14.99",
    "category": "Clothing"
  },
  {
    "credit_card_company": "Discover",
    "transaction_date": "2019-12-03T16:50:19.851+01:00",
    "price": "188",
    "category": "Entertainment"
  },
  {
    "credit_card_company": "American Express",
    "transaction_date": "2017-03-20T18:39:14.307+01:00",
    "price": "52.99",
    "category": "Automotive"
  },
  {
    "credit_card_company": "MasterCard",
    "transaction_date": "2020-08-08T14:49:33.695+02:00",
    "price": "83.95",
    "category": "Clothing"
  },
  {
    "credit_card_company": "American Express",
    "transaction_date": "2017-11-27T22:17:50.482+01:00",
    "price": "73",
    "category": "Automotive"
  },
  {
    "credit_card_company": "Discover",
    "transaction_date": "2013-07-15T00:12:43.934+02:00",
    "price": "149.99",
    "category": "Clothing"
  },
  {
    "credit_card_company": "American Express",
    "transaction_date": "2017-02-09T08:47:31.482+01:00",
    "price": "73",
    "category": "Automotive"
  },
  {
    "credit_card_company": "Discover",
    "transaction_date": "2016-02-02T16:29:01.889+01:00",
    "price": "155.95",
    "category": "Entertainment"
  },
  {
    "credit_card_company": "VISA",
    "transaction_date": "2021-01-31T10:44:37.063+01:00",
    "price": "62",
    "category": "Entertainment"
  },
  {
    "credit_card_company": "MasterCard",
    "transaction_date": "2021-05-27T18:56:22.869+02:00",
    "price": "54",
    "category": "Home"
  },
  {
    "credit_card_company": "Discover",
    "transaction_date": "2021-10-16T17:55:49.284+02:00",
    "price": "20.95",
    "category": "Automotive"
  },
  {
    "credit_card_company": "MasterCard",
    "transaction_date": "2013-07-22T13:51:21.551+02:00",
    "price": "96",
    "category": "Activity"
  },
  {
    "credit_card_company": "MasterCard",
    "transaction_date": "2018-06-04T10:44:53.033+02:00",
    "price": "69",
    "category": "Electronics"
  },
  {
    "credit_card_company": "American Express",
    "transaction_date": "2013-02-18T23:53:39.923+01:00",
    "price": "156",
    "category": "Health"
  },
  {
    "credit_card_company": "American Express",
    "transaction_date": "2014-03-26T14:20:17.537+01:00",
    "price": "30.95",
    "category": "Beauty"
  },
  {
    "credit_card_company": "MasterCard",
    "transaction_date": "2013-01-06T03:08:41.113+01:00",
    "price": "112.99",
    "category": "Home"
  },
  {
    "credit_card_company": "VISA",
    "transaction_date": "2011-01-03T05:47:28.286+01:00",
    "price": "79",
    "category": "Clothing"
  },
  {
    "credit_card_company": "American Express",
    "transaction_date": "2013-03-23T19:47:56.744+01:00",
    "price": "142",
    "category": "Automotive"
  },
  {
    "credit_card_company": "VISA",
    "transaction_date": "2020-02-25T21:42:10.852+01:00",
    "price": "138.99",
    "category": "Electronics"
  },
  {
    "credit_card_company": "Discover",
    "transaction_date": "2020-06-09T12:04:15.638+02:00",
    "price": "39.99",
    "category": "Home"
  },
  {
    "credit_card_company": "American Express",
    "transaction_date": "2018-03-17T05:51:36.152+01:00",
    "price": "90.95",
    "category": "Home"
  },
  {
    "credit_card_company": "Discover",
    "transaction_date": "2021-01-30T19:24:01.120+01:00",
    "price": "124",
    "category": "Clothing"
  },
  {
    "credit_card_company": "MasterCard",
    "transaction_date": "2011-12-19T17:33:29.745+01:00",
    "price": "148.95",
    "category": "Pets"
  },
  {
    "credit_card_company": "American Express",
    "transaction_date": "2019-10-03T05:36:29.985+02:00",
    "price": "175",
    "category": "Entertainment"
  },
  {
    "credit_card_company": "VISA",
    "transaction_date": "2016-11-14T06:48:11.978+01:00",
    "price": "67",
    "category": "Activity"
  },
  {
    "credit_card_company": "American Express",
    "transaction_date": "2013-10-10T03:32:14.544+02:00",
    "price": "174.95",
    "category": "Beauty"
  },
  {
    "credit_card_company": "Discover",
    "transaction_date": "2011-06-26T01:11:27.080+02:00",
    "price": "62.95",
    "category": "Beauty"
  }
]

  module.exports = {
    data,
  }