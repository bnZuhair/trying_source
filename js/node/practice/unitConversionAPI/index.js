const express = require('express');
const app = express()
const PORT = 3000

const conversionMap = {
   // Distance
   km: {
      miles: (val) => val * 0.621371,
      m: (val) => val * 1000,
      ft: (val) => val * 3280.84,
      cm: (val) => val * 100000,
      inches: (val) => val * 39370.1,
   },
   miles: {
      km: (val) => val / 0.621371,
      m: (val) => val * 1609.34,
      ft: (val) => val * 5280,
      cm: (val) => val * 160934,
      inches: (val) => val * 63360,
   },
   m: {
      km: (val) => val / 1000,
      miles: (val) => val / 1609.34,
      ft: (val) => val * 3.28084,
      cm: (val) => val * 100,
      inches: (val) => val * 39.3701,
   },
   ft: {
      km: (val) => val / 3280.84,
      miles: (val) => val / 5280,
      m: (val) => val / 3.28084,
      cm: (val) => val * 30.48,
      inches: (val) => val * 12,
   },
   cm: {
      km: (val) => val / 100000,
      miles: (val) => val / 160934,
      m: (val) => val / 100,
      ft: (val) => val / 30.48,
      inches: (val) => val / 2.54,
   },
   inches: {
      km: (val) => val / 39370.1,
      miles: (val) => val / 63360,
      m: (val) => val / 39.3701,
      ft: (val) => val / 12,
      cm: (val) => val * 2.54,
   },

   // Weight
   kg: {
      pounds: (val) => val * 2.20462,
      g: (val) => val * 1000,
      oz: (val) => val * 35.274,
   },
   pounds: {
      kg: (val) => val / 2.20462,
      g: (val) => val * 453.592,
      oz: (val) => val * 16,
   },
   g: {
      kg: (val) => val / 1000,
      pounds: (val) => val / 453.592,
      oz: (val) => val * 0.035274,
   },
   oz: {
      kg: (val) => val / 35.274,
      pounds: (val) => val / 16,
      g: (val) => val / 0.035274,
   },

   // Temperature
   celsius: {
      fahrenheit: (val) => (val * 9) / 5 + 32,
      kelvin: (val) => val + 273.15,
   },
   fahrenheit: {
      celsius: (val) => ((val - 32) * 5) / 9,
      kelvin: (val) => ((val - 32) * 5) / 9 + 273.15,
   },
   kelvin: {
      celsius: (val) => val - 273.15,
      fahrenheit: (val) => ((val - 273.15) * 9) / 5 + 32,
   },
};

app.get("/convert", (req, res) => {
   const { from, to, valueRaw } = req.query;
   const value = parseFloat(valueRaw);

   if (!from || !to || value === undefined) {
      return res.status(400).json({
         status: 400,
         message: "Missing query parameters. Required: from, to, value.",
      });
   }
   if (isNaN(value)) {
      return res.status(400).json({
         status: 400,
         message: "Value must be a number.",
      });
   }
   const converte_func = conversionMap[from]?.[to];
   if (converte_func) {
      const result = converte_func(value);
      res.status(200).json(
         {
            "status": 200,
            "result": {
               "from": from,
               "to": to,
               "original_value": value,
               "converted_value": result,
            }
         }
      )

   } else {
      res.status(422).json(
         {
            "status": 422,
            message: `unspported conversion from ${from} to ${to}`,
         }
      )
   }

})


app.listen(PORT, () => {
   console.log(`API running on port ${PORT}`)
}
)
