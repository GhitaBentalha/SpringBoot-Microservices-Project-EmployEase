const express = require('express');
const { createProxyMiddleware } = require('http-proxy-middleware');

const app = express();

// Rediriger les requêtes /api vers le backend
app.use('/api', createProxyMiddleware({
    target: 'http://localhost:8080',
    changeOrigin: true,
}));

// Servir les fichiers statiques (HTML, CSS, JS)
app.use(express.static('public'));

app.listen(8085, () => {
    console.log('Proxy server running on http://127.0.0.1:8085');
});