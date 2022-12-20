module.exports = function override(config, env) {
    config.devServer = {
        port: 3000,
            proxy: {
            '/business': {
                target: `http://localhost:5001`,
                    secure: false
            }
        }
    }
    return config;
}