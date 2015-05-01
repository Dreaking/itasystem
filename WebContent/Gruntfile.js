var lessFilePairs = [  
    {"css/iTA_register.css": "less/iTA_register.less" }
];  
module.exports = function(grunt){
    grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),
    watch: {
       less: {
            files: ['**/*.less'],
            tasks:['less:student'],
            options: {livereload:false}
        }
       // imagemin:{
       //      files: ['webroot/**/*.{png,jpg,jpeg}'],
       //      tasks:['imagemin:dist'],
       //      options: {livereload:false}
       // }
        // js:{

        // }
    },
    less: {
        student:{
            options: {
                plugins:[
                new (require('less-plugin-autoprefix'))({browsers: ["last 20 versions"]})
                // new (require('less-plugin-clean-css'))({advanced: true})
                ]
            },
            files:lessFilePairs
        },
        login:{
            options: {
                plugins:[
                new (require('less-plugin-autoprefix'))({browsers: ["last 20 versions"]})
                // new (require('less-plugin-clean-css'))({advanced: true})
                ]
            },
            files: lessFilePairs
        }
    },
    imagemin: {
            /* 压缩图片大小 */
            dist: {
                options: {
                    optimizationLevel: 3 //定义 PNG 图片优化水平
                },
                files: [
                       {
                        expand: true,
                        cwd: 'imgs/',
                        src: ['**/*.{png,jpg,jpeg}'], // 优化 img 目录下所有 png/jpg/jpeg 图片
                        dest: 'imgs/' // 优化后的图片保存位置，覆盖旧图片，并且不作提示
                    }
                    ]
                }
            },
    });
    grunt.loadNpmTasks('grunt-contrib-uglify');
    grunt.loadNpmTasks('grunt-contrib-imagemin');
    grunt.loadNpmTasks('grunt-contrib-watch');
    grunt.loadNpmTasks('grunt-contrib-less');
    grunt.registerTask('default', ['watch']);
    grunt.registerTask('img', ['imagemin']);
};