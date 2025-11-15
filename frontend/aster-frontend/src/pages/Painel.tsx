import Estrategia_D from "./Painel/Estrategia_D"
import Estrategia_I from "./Painel/Estrategia_I"
import Financas_D from "./Painel/Financas_D"
import Financas_I from "./Painel/Financas_I"
import Tech_D from "./Painel/Tech_D"
import Tech_I from "./Painel/Tech_I"

export const painelRoutes = [
  {
    path: "painel",
    children: [
      { path: "d/estrategia", element: <Estrategia_D /> },
      { path: "d/financas", element: <Financas_D /> },
      { path: "d/tech", element: <Tech_D /> },

      { path: "i/estrategia", element: <Estrategia_I /> },
      { path: "i/financas", element: <Financas_I /> },
      { path: "i/tech", element: <Tech_I /> }
    ]
  }
];
