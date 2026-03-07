import * as React from 'react';
import { Admin, Resource } from 'react-admin';
import polyglotI18nProvider from 'ra-i18n-polyglot';

import authProvider from './authProvider';
import themeReducer from './themeReducer';
import { Login, Layout } from './layout';
import { Dashboard } from './dashboard';
import customRoutes from './routes';
import englishMessages from './i18n/en';

import visitors from './visitors';
import orders from './orders';
import products from './products';
import invoices from './invoices';
import categories from './categories';
import reviews from './reviews';
import dataProvider from './dataProvider';
import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import ControlsPage from "./pages/ControlsPage";
import ActionsPage from "./pages/ActionsPage";
import RexPage from "./pages/RexPage";
import AnalysesPage from "./pages/AnalysesPage";
import PersonnelPage from "./pages/PersonnelPage";
import Dashboard from "./pages/Dashboard";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Dashboard />} />
        <Route path="/controls" element={<ControlsPage />} />
        <Route path="/actions" element={<ActionsPage />} />
        <Route path="/rex" element={<RexPage />} />
        <Route path="/analyses" element={<AnalysesPage />} />
        <Route path="/personnel" element={<PersonnelPage />} />
      </Routes>
    </Router>
  );
}

export default App;
const i18nProvider = polyglotI18nProvider(locale => {
    if (locale === 'fr') {
        return import('./i18n/fr').then(messages => messages.default);
    }

    // Always fallback on english
    return englishMessages;
}, 'en');

const App = () => {
    return (
        <Admin
            title=""
            dataProvider={dataProvider}
            customReducers={{ theme: themeReducer }}
            customRoutes={customRoutes}
            authProvider={authProvider}
            dashboard={Dashboard}
            loginPage={Login}
            layout={Layout}
            i18nProvider={i18nProvider}
            disableTelemetry
        >
            <Resource name="customers" {...visitors} />
            <Resource
                name="commands"
                {...orders}
                options={{ label: 'Orders' }}
            />
            <Resource name="invoices" {...invoices} />
            <Resource name="products" {...products} />
            <Resource name="categories" {...categories} />
            <Resource name="reviews" {...reviews} />
        </Admin>
    );
};

export default App;
