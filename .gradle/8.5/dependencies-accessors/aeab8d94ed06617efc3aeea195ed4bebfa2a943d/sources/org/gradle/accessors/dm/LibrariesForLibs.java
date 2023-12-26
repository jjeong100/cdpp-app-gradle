package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the `libs` extension.
 */
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final ComLibraryAccessors laccForComLibraryAccessors = new ComLibraryAccessors(owner);
    private final CommonsLibraryAccessors laccForCommonsLibraryAccessors = new CommonsLibraryAccessors(owner);
    private final IoLibraryAccessors laccForIoLibraryAccessors = new IoLibraryAccessors(owner);
    private final JavaxLibraryAccessors laccForJavaxLibraryAccessors = new JavaxLibraryAccessors(owner);
    private final OrgLibraryAccessors laccForOrgLibraryAccessors = new OrgLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

    /**
     * Returns the group of libraries at com
     */
    public ComLibraryAccessors getCom() {
        return laccForComLibraryAccessors;
    }

    /**
     * Returns the group of libraries at commons
     */
    public CommonsLibraryAccessors getCommons() {
        return laccForCommonsLibraryAccessors;
    }

    /**
     * Returns the group of libraries at io
     */
    public IoLibraryAccessors getIo() {
        return laccForIoLibraryAccessors;
    }

    /**
     * Returns the group of libraries at javax
     */
    public JavaxLibraryAccessors getJavax() {
        return laccForJavaxLibraryAccessors;
    }

    /**
     * Returns the group of libraries at org
     */
    public OrgLibraryAccessors getOrg() {
        return laccForOrgLibraryAccessors;
    }

    /**
     * Returns the group of versions at versions
     */
    public VersionAccessors getVersions() {
        return vaccForVersionAccessors;
    }

    /**
     * Returns the group of bundles at bundles
     */
    public BundleAccessors getBundles() {
        return baccForBundleAccessors;
    }

    /**
     * Returns the group of plugins at plugins
     */
    public PluginAccessors getPlugins() {
        return paccForPluginAccessors;
    }

    public static class ComLibraryAccessors extends SubDependencyFactory {
        private final ComFasterxmlLibraryAccessors laccForComFasterxmlLibraryAccessors = new ComFasterxmlLibraryAccessors(owner);
        private final ComGoogleLibraryAccessors laccForComGoogleLibraryAccessors = new ComGoogleLibraryAccessors(owner);
        private final ComGooglecodeLibraryAccessors laccForComGooglecodeLibraryAccessors = new ComGooglecodeLibraryAccessors(owner);

        public ComLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.fasterxml
         */
        public ComFasterxmlLibraryAccessors getFasterxml() {
            return laccForComFasterxmlLibraryAccessors;
        }

        /**
         * Returns the group of libraries at com.google
         */
        public ComGoogleLibraryAccessors getGoogle() {
            return laccForComGoogleLibraryAccessors;
        }

        /**
         * Returns the group of libraries at com.googlecode
         */
        public ComGooglecodeLibraryAccessors getGooglecode() {
            return laccForComGooglecodeLibraryAccessors;
        }

    }

    public static class ComFasterxmlLibraryAccessors extends SubDependencyFactory {
        private final ComFasterxmlJacksonLibraryAccessors laccForComFasterxmlJacksonLibraryAccessors = new ComFasterxmlJacksonLibraryAccessors(owner);

        public ComFasterxmlLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.fasterxml.jackson
         */
        public ComFasterxmlJacksonLibraryAccessors getJackson() {
            return laccForComFasterxmlJacksonLibraryAccessors;
        }

    }

    public static class ComFasterxmlJacksonLibraryAccessors extends SubDependencyFactory {
        private final ComFasterxmlJacksonCoreLibraryAccessors laccForComFasterxmlJacksonCoreLibraryAccessors = new ComFasterxmlJacksonCoreLibraryAccessors(owner);

        public ComFasterxmlJacksonLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.fasterxml.jackson.core
         */
        public ComFasterxmlJacksonCoreLibraryAccessors getCore() {
            return laccForComFasterxmlJacksonCoreLibraryAccessors;
        }

    }

    public static class ComFasterxmlJacksonCoreLibraryAccessors extends SubDependencyFactory {
        private final ComFasterxmlJacksonCoreJacksonLibraryAccessors laccForComFasterxmlJacksonCoreJacksonLibraryAccessors = new ComFasterxmlJacksonCoreJacksonLibraryAccessors(owner);

        public ComFasterxmlJacksonCoreLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.fasterxml.jackson.core.jackson
         */
        public ComFasterxmlJacksonCoreJacksonLibraryAccessors getJackson() {
            return laccForComFasterxmlJacksonCoreJacksonLibraryAccessors;
        }

    }

    public static class ComFasterxmlJacksonCoreJacksonLibraryAccessors extends SubDependencyFactory {

        public ComFasterxmlJacksonCoreJacksonLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for databind (com.fasterxml.jackson.core:jackson-databind)
         * with versionRef 'com.fasterxml.jackson.core.jackson.databind'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getDatabind() {
                return create("com.fasterxml.jackson.core.jackson.databind");
        }

    }

    public static class ComGoogleLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleCodeLibraryAccessors$1 laccForComGoogleCodeLibraryAccessors$1 = new ComGoogleCodeLibraryAccessors$1(owner);

        public ComGoogleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.google.code
         */
        public ComGoogleCodeLibraryAccessors$1 getCode() {
            return laccForComGoogleCodeLibraryAccessors$1;
        }

    }

    public static class ComGoogleCodeLibraryAccessors$1 extends SubDependencyFactory {
        private final ComGoogleCodeGsonLibraryAccessors laccForComGoogleCodeGsonLibraryAccessors = new ComGoogleCodeGsonLibraryAccessors(owner);

        public ComGoogleCodeLibraryAccessors$1(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.google.code.gson
         */
        public ComGoogleCodeGsonLibraryAccessors getGson() {
            return laccForComGoogleCodeGsonLibraryAccessors;
        }

    }

    public static class ComGoogleCodeGsonLibraryAccessors extends SubDependencyFactory {

        public ComGoogleCodeGsonLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for gson (com.google.code.gson:gson)
         * with versionRef 'com.google.code.gson.gson'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getGson() {
                return create("com.google.code.gson.gson");
        }

    }

    public static class ComGooglecodeLibraryAccessors extends SubDependencyFactory {
        private final ComGooglecodeJsonLibraryAccessors laccForComGooglecodeJsonLibraryAccessors = new ComGooglecodeJsonLibraryAccessors(owner);

        public ComGooglecodeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.googlecode.json
         */
        public ComGooglecodeJsonLibraryAccessors getJson() {
            return laccForComGooglecodeJsonLibraryAccessors;
        }

    }

    public static class ComGooglecodeJsonLibraryAccessors extends SubDependencyFactory {
        private final ComGooglecodeJsonSimpleLibraryAccessors laccForComGooglecodeJsonSimpleLibraryAccessors = new ComGooglecodeJsonSimpleLibraryAccessors(owner);

        public ComGooglecodeJsonLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.googlecode.json.simple
         */
        public ComGooglecodeJsonSimpleLibraryAccessors getSimple() {
            return laccForComGooglecodeJsonSimpleLibraryAccessors;
        }

    }

    public static class ComGooglecodeJsonSimpleLibraryAccessors extends SubDependencyFactory {
        private final ComGooglecodeJsonSimpleJsonLibraryAccessors laccForComGooglecodeJsonSimpleJsonLibraryAccessors = new ComGooglecodeJsonSimpleJsonLibraryAccessors(owner);

        public ComGooglecodeJsonSimpleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.googlecode.json.simple.json
         */
        public ComGooglecodeJsonSimpleJsonLibraryAccessors getJson() {
            return laccForComGooglecodeJsonSimpleJsonLibraryAccessors;
        }

    }

    public static class ComGooglecodeJsonSimpleJsonLibraryAccessors extends SubDependencyFactory {

        public ComGooglecodeJsonSimpleJsonLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for simple (com.googlecode.json-simple:json-simple)
         * with versionRef 'com.googlecode.json.simple.json.simple'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getSimple() {
                return create("com.googlecode.json.simple.json.simple");
        }

    }

    public static class CommonsLibraryAccessors extends SubDependencyFactory {
        private final CommonsFileuploadLibraryAccessors laccForCommonsFileuploadLibraryAccessors = new CommonsFileuploadLibraryAccessors(owner);

        public CommonsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at commons.fileupload
         */
        public CommonsFileuploadLibraryAccessors getFileupload() {
            return laccForCommonsFileuploadLibraryAccessors;
        }

    }

    public static class CommonsFileuploadLibraryAccessors extends SubDependencyFactory {
        private final CommonsFileuploadCommonsLibraryAccessors laccForCommonsFileuploadCommonsLibraryAccessors = new CommonsFileuploadCommonsLibraryAccessors(owner);

        public CommonsFileuploadLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at commons.fileupload.commons
         */
        public CommonsFileuploadCommonsLibraryAccessors getCommons() {
            return laccForCommonsFileuploadCommonsLibraryAccessors;
        }

    }

    public static class CommonsFileuploadCommonsLibraryAccessors extends SubDependencyFactory {

        public CommonsFileuploadCommonsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for fileupload (commons-fileupload:commons-fileupload)
         * with versionRef 'commons.fileupload.commons.fileupload'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getFileupload() {
                return create("commons.fileupload.commons.fileupload");
        }

    }

    public static class IoLibraryAccessors extends SubDependencyFactory {
        private final IoJsonwebtokenLibraryAccessors laccForIoJsonwebtokenLibraryAccessors = new IoJsonwebtokenLibraryAccessors(owner);

        public IoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at io.jsonwebtoken
         */
        public IoJsonwebtokenLibraryAccessors getJsonwebtoken() {
            return laccForIoJsonwebtokenLibraryAccessors;
        }

    }

    public static class IoJsonwebtokenLibraryAccessors extends SubDependencyFactory {
        private final IoJsonwebtokenJjwtLibraryAccessors laccForIoJsonwebtokenJjwtLibraryAccessors = new IoJsonwebtokenJjwtLibraryAccessors(owner);

        public IoJsonwebtokenLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at io.jsonwebtoken.jjwt
         */
        public IoJsonwebtokenJjwtLibraryAccessors getJjwt() {
            return laccForIoJsonwebtokenJjwtLibraryAccessors;
        }

    }

    public static class IoJsonwebtokenJjwtLibraryAccessors extends SubDependencyFactory {

        public IoJsonwebtokenJjwtLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for jackson (io.jsonwebtoken:jjwt-jackson)
         * with versionRef 'io.jsonwebtoken.jjwt.jackson'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJackson() {
                return create("io.jsonwebtoken.jjwt.jackson");
        }

    }

    public static class JavaxLibraryAccessors extends SubDependencyFactory {
        private final JavaxServletLibraryAccessors laccForJavaxServletLibraryAccessors = new JavaxServletLibraryAccessors(owner);

        public JavaxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at javax.servlet
         */
        public JavaxServletLibraryAccessors getServlet() {
            return laccForJavaxServletLibraryAccessors;
        }

    }

    public static class JavaxServletLibraryAccessors extends SubDependencyFactory {

        public JavaxServletLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for jstl (javax.servlet:jstl)
         * with versionRef 'javax.servlet.jstl'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJstl() {
                return create("javax.servlet.jstl");
        }

    }

    public static class OrgLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheLibraryAccessors laccForOrgApacheLibraryAccessors = new OrgApacheLibraryAccessors(owner);
        private final OrgBgeeLibraryAccessors laccForOrgBgeeLibraryAccessors = new OrgBgeeLibraryAccessors(owner);
        private final OrgCodehausLibraryAccessors laccForOrgCodehausLibraryAccessors = new OrgCodehausLibraryAccessors(owner);
        private final OrgHibernateLibraryAccessors laccForOrgHibernateLibraryAccessors = new OrgHibernateLibraryAccessors(owner);
        private final OrgJsonLibraryAccessors laccForOrgJsonLibraryAccessors = new OrgJsonLibraryAccessors(owner);
        private final OrgModelmapperLibraryAccessors laccForOrgModelmapperLibraryAccessors = new OrgModelmapperLibraryAccessors(owner);
        private final OrgMybatisLibraryAccessors laccForOrgMybatisLibraryAccessors = new OrgMybatisLibraryAccessors(owner);
        private final OrgPostgresqlLibraryAccessors laccForOrgPostgresqlLibraryAccessors = new OrgPostgresqlLibraryAccessors(owner);
        private final OrgProjectlombokLibraryAccessors laccForOrgProjectlombokLibraryAccessors = new OrgProjectlombokLibraryAccessors(owner);
        private final OrgSpringdocLibraryAccessors laccForOrgSpringdocLibraryAccessors = new OrgSpringdocLibraryAccessors(owner);
        private final OrgSpringframeworkLibraryAccessors laccForOrgSpringframeworkLibraryAccessors = new OrgSpringframeworkLibraryAccessors(owner);

        public OrgLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.apache
         */
        public OrgApacheLibraryAccessors getApache() {
            return laccForOrgApacheLibraryAccessors;
        }

        /**
         * Returns the group of libraries at org.bgee
         */
        public OrgBgeeLibraryAccessors getBgee() {
            return laccForOrgBgeeLibraryAccessors;
        }

        /**
         * Returns the group of libraries at org.codehaus
         */
        public OrgCodehausLibraryAccessors getCodehaus() {
            return laccForOrgCodehausLibraryAccessors;
        }

        /**
         * Returns the group of libraries at org.hibernate
         */
        public OrgHibernateLibraryAccessors getHibernate() {
            return laccForOrgHibernateLibraryAccessors;
        }

        /**
         * Returns the group of libraries at org.json
         */
        public OrgJsonLibraryAccessors getJson() {
            return laccForOrgJsonLibraryAccessors;
        }

        /**
         * Returns the group of libraries at org.modelmapper
         */
        public OrgModelmapperLibraryAccessors getModelmapper() {
            return laccForOrgModelmapperLibraryAccessors;
        }

        /**
         * Returns the group of libraries at org.mybatis
         */
        public OrgMybatisLibraryAccessors getMybatis() {
            return laccForOrgMybatisLibraryAccessors;
        }

        /**
         * Returns the group of libraries at org.postgresql
         */
        public OrgPostgresqlLibraryAccessors getPostgresql() {
            return laccForOrgPostgresqlLibraryAccessors;
        }

        /**
         * Returns the group of libraries at org.projectlombok
         */
        public OrgProjectlombokLibraryAccessors getProjectlombok() {
            return laccForOrgProjectlombokLibraryAccessors;
        }

        /**
         * Returns the group of libraries at org.springdoc
         */
        public OrgSpringdocLibraryAccessors getSpringdoc() {
            return laccForOrgSpringdocLibraryAccessors;
        }

        /**
         * Returns the group of libraries at org.springframework
         */
        public OrgSpringframeworkLibraryAccessors getSpringframework() {
            return laccForOrgSpringframeworkLibraryAccessors;
        }

    }

    public static class OrgApacheLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheCassandraLibraryAccessors laccForOrgApacheCassandraLibraryAccessors = new OrgApacheCassandraLibraryAccessors(owner);
        private final OrgApacheHttpcomponentsLibraryAccessors laccForOrgApacheHttpcomponentsLibraryAccessors = new OrgApacheHttpcomponentsLibraryAccessors(owner);

        public OrgApacheLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.apache.cassandra
         */
        public OrgApacheCassandraLibraryAccessors getCassandra() {
            return laccForOrgApacheCassandraLibraryAccessors;
        }

        /**
         * Returns the group of libraries at org.apache.httpcomponents
         */
        public OrgApacheHttpcomponentsLibraryAccessors getHttpcomponents() {
            return laccForOrgApacheHttpcomponentsLibraryAccessors;
        }

    }

    public static class OrgApacheCassandraLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheCassandraCassandraLibraryAccessors laccForOrgApacheCassandraCassandraLibraryAccessors = new OrgApacheCassandraCassandraLibraryAccessors(owner);

        public OrgApacheCassandraLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.apache.cassandra.cassandra
         */
        public OrgApacheCassandraCassandraLibraryAccessors getCassandra() {
            return laccForOrgApacheCassandraCassandraLibraryAccessors;
        }

    }

    public static class OrgApacheCassandraCassandraLibraryAccessors extends SubDependencyFactory {

        public OrgApacheCassandraCassandraLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for all (org.apache.cassandra:cassandra-all)
         * with versionRef 'org.apache.cassandra.cassandra.all'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAll() {
                return create("org.apache.cassandra.cassandra.all");
        }

    }

    public static class OrgApacheHttpcomponentsLibraryAccessors extends SubDependencyFactory {

        public OrgApacheHttpcomponentsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for httpmime (org.apache.httpcomponents:httpmime)
         * with versionRef 'org.apache.httpcomponents.httpmime'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getHttpmime() {
                return create("org.apache.httpcomponents.httpmime");
        }

    }

    public static class OrgBgeeLibraryAccessors extends SubDependencyFactory {
        private final OrgBgeeLog4jdbcLibraryAccessors laccForOrgBgeeLog4jdbcLibraryAccessors = new OrgBgeeLog4jdbcLibraryAccessors(owner);

        public OrgBgeeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.bgee.log4jdbc
         */
        public OrgBgeeLog4jdbcLibraryAccessors getLog4jdbc() {
            return laccForOrgBgeeLog4jdbcLibraryAccessors;
        }

    }

    public static class OrgBgeeLog4jdbcLibraryAccessors extends SubDependencyFactory {
        private final OrgBgeeLog4jdbcLog4j2LibraryAccessors laccForOrgBgeeLog4jdbcLog4j2LibraryAccessors = new OrgBgeeLog4jdbcLog4j2LibraryAccessors(owner);

        public OrgBgeeLog4jdbcLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.bgee.log4jdbc.log4j2
         */
        public OrgBgeeLog4jdbcLog4j2LibraryAccessors getLog4j2() {
            return laccForOrgBgeeLog4jdbcLog4j2LibraryAccessors;
        }

    }

    public static class OrgBgeeLog4jdbcLog4j2LibraryAccessors extends SubDependencyFactory {
        private final OrgBgeeLog4jdbcLog4j2Log4jdbcLibraryAccessors laccForOrgBgeeLog4jdbcLog4j2Log4jdbcLibraryAccessors = new OrgBgeeLog4jdbcLog4j2Log4jdbcLibraryAccessors(owner);

        public OrgBgeeLog4jdbcLog4j2LibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.bgee.log4jdbc.log4j2.log4jdbc
         */
        public OrgBgeeLog4jdbcLog4j2Log4jdbcLibraryAccessors getLog4jdbc() {
            return laccForOrgBgeeLog4jdbcLog4j2Log4jdbcLibraryAccessors;
        }

    }

    public static class OrgBgeeLog4jdbcLog4j2Log4jdbcLibraryAccessors extends SubDependencyFactory {
        private final OrgBgeeLog4jdbcLog4j2Log4jdbcLog4j2LibraryAccessors laccForOrgBgeeLog4jdbcLog4j2Log4jdbcLog4j2LibraryAccessors = new OrgBgeeLog4jdbcLog4j2Log4jdbcLog4j2LibraryAccessors(owner);

        public OrgBgeeLog4jdbcLog4j2Log4jdbcLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.bgee.log4jdbc.log4j2.log4jdbc.log4j2
         */
        public OrgBgeeLog4jdbcLog4j2Log4jdbcLog4j2LibraryAccessors getLog4j2() {
            return laccForOrgBgeeLog4jdbcLog4j2Log4jdbcLog4j2LibraryAccessors;
        }

    }

    public static class OrgBgeeLog4jdbcLog4j2Log4jdbcLog4j2LibraryAccessors extends SubDependencyFactory {

        public OrgBgeeLog4jdbcLog4j2Log4jdbcLog4j2LibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for jdbc4 (org.bgee.log4jdbc-log4j2:log4jdbc-log4j2-jdbc4)
         * with versionRef 'org.bgee.log4jdbc.log4j2.log4jdbc.log4j2.jdbc4'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJdbc4() {
                return create("org.bgee.log4jdbc.log4j2.log4jdbc.log4j2.jdbc4");
        }

    }

    public static class OrgCodehausLibraryAccessors extends SubDependencyFactory {
        private final OrgCodehausJacksonLibraryAccessors laccForOrgCodehausJacksonLibraryAccessors = new OrgCodehausJacksonLibraryAccessors(owner);

        public OrgCodehausLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.codehaus.jackson
         */
        public OrgCodehausJacksonLibraryAccessors getJackson() {
            return laccForOrgCodehausJacksonLibraryAccessors;
        }

    }

    public static class OrgCodehausJacksonLibraryAccessors extends SubDependencyFactory {
        private final OrgCodehausJacksonJacksonLibraryAccessors laccForOrgCodehausJacksonJacksonLibraryAccessors = new OrgCodehausJacksonJacksonLibraryAccessors(owner);

        public OrgCodehausJacksonLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.codehaus.jackson.jackson
         */
        public OrgCodehausJacksonJacksonLibraryAccessors getJackson() {
            return laccForOrgCodehausJacksonJacksonLibraryAccessors;
        }

    }

    public static class OrgCodehausJacksonJacksonLibraryAccessors extends SubDependencyFactory {
        private final OrgCodehausJacksonJacksonMapperLibraryAccessors laccForOrgCodehausJacksonJacksonMapperLibraryAccessors = new OrgCodehausJacksonJacksonMapperLibraryAccessors(owner);

        public OrgCodehausJacksonJacksonLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.codehaus.jackson.jackson.mapper
         */
        public OrgCodehausJacksonJacksonMapperLibraryAccessors getMapper() {
            return laccForOrgCodehausJacksonJacksonMapperLibraryAccessors;
        }

    }

    public static class OrgCodehausJacksonJacksonMapperLibraryAccessors extends SubDependencyFactory {

        public OrgCodehausJacksonJacksonMapperLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for asl (org.codehaus.jackson:jackson-mapper-asl)
         * with versionRef 'org.codehaus.jackson.jackson.mapper.asl'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAsl() {
                return create("org.codehaus.jackson.jackson.mapper.asl");
        }

    }

    public static class OrgHibernateLibraryAccessors extends SubDependencyFactory {
        private final OrgHibernateHibernateLibraryAccessors laccForOrgHibernateHibernateLibraryAccessors = new OrgHibernateHibernateLibraryAccessors(owner);

        public OrgHibernateLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.hibernate.hibernate
         */
        public OrgHibernateHibernateLibraryAccessors getHibernate() {
            return laccForOrgHibernateHibernateLibraryAccessors;
        }

    }

    public static class OrgHibernateHibernateLibraryAccessors extends SubDependencyFactory {

        public OrgHibernateHibernateLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for validator (org.hibernate:hibernate-validator)
         * with versionRef 'org.hibernate.hibernate.validator'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getValidator() {
                return create("org.hibernate.hibernate.validator");
        }

    }

    public static class OrgJsonLibraryAccessors extends SubDependencyFactory {

        public OrgJsonLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for json (org.json:json)
         * with versionRef 'org.json.json'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJson() {
                return create("org.json.json");
        }

    }

    public static class OrgModelmapperLibraryAccessors extends SubDependencyFactory {

        public OrgModelmapperLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for modelmapper (org.modelmapper:modelmapper)
         * with versionRef 'org.modelmapper.modelmapper'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getModelmapper() {
                return create("org.modelmapper.modelmapper");
        }

    }

    public static class OrgMybatisLibraryAccessors extends SubDependencyFactory {
        private final OrgMybatisSpringLibraryAccessors laccForOrgMybatisSpringLibraryAccessors = new OrgMybatisSpringLibraryAccessors(owner);

        public OrgMybatisLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.mybatis.spring
         */
        public OrgMybatisSpringLibraryAccessors getSpring() {
            return laccForOrgMybatisSpringLibraryAccessors;
        }

    }

    public static class OrgMybatisSpringLibraryAccessors extends SubDependencyFactory {
        private final OrgMybatisSpringBootLibraryAccessors laccForOrgMybatisSpringBootLibraryAccessors = new OrgMybatisSpringBootLibraryAccessors(owner);

        public OrgMybatisSpringLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.mybatis.spring.boot
         */
        public OrgMybatisSpringBootLibraryAccessors getBoot() {
            return laccForOrgMybatisSpringBootLibraryAccessors;
        }

    }

    public static class OrgMybatisSpringBootLibraryAccessors extends SubDependencyFactory {
        private final OrgMybatisSpringBootMybatisLibraryAccessors laccForOrgMybatisSpringBootMybatisLibraryAccessors = new OrgMybatisSpringBootMybatisLibraryAccessors(owner);

        public OrgMybatisSpringBootLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.mybatis.spring.boot.mybatis
         */
        public OrgMybatisSpringBootMybatisLibraryAccessors getMybatis() {
            return laccForOrgMybatisSpringBootMybatisLibraryAccessors;
        }

    }

    public static class OrgMybatisSpringBootMybatisLibraryAccessors extends SubDependencyFactory {
        private final OrgMybatisSpringBootMybatisSpringLibraryAccessors laccForOrgMybatisSpringBootMybatisSpringLibraryAccessors = new OrgMybatisSpringBootMybatisSpringLibraryAccessors(owner);

        public OrgMybatisSpringBootMybatisLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.mybatis.spring.boot.mybatis.spring
         */
        public OrgMybatisSpringBootMybatisSpringLibraryAccessors getSpring() {
            return laccForOrgMybatisSpringBootMybatisSpringLibraryAccessors;
        }

    }

    public static class OrgMybatisSpringBootMybatisSpringLibraryAccessors extends SubDependencyFactory {
        private final OrgMybatisSpringBootMybatisSpringBootLibraryAccessors laccForOrgMybatisSpringBootMybatisSpringBootLibraryAccessors = new OrgMybatisSpringBootMybatisSpringBootLibraryAccessors(owner);

        public OrgMybatisSpringBootMybatisSpringLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.mybatis.spring.boot.mybatis.spring.boot
         */
        public OrgMybatisSpringBootMybatisSpringBootLibraryAccessors getBoot() {
            return laccForOrgMybatisSpringBootMybatisSpringBootLibraryAccessors;
        }

    }

    public static class OrgMybatisSpringBootMybatisSpringBootLibraryAccessors extends SubDependencyFactory {

        public OrgMybatisSpringBootMybatisSpringBootLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for starter (org.mybatis.spring.boot:mybatis-spring-boot-starter)
         * with versionRef 'org.mybatis.spring.boot.mybatis.spring.boot.starter'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getStarter() {
                return create("org.mybatis.spring.boot.mybatis.spring.boot.starter");
        }

    }

    public static class OrgPostgresqlLibraryAccessors extends SubDependencyFactory {

        public OrgPostgresqlLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for postgresql (org.postgresql:postgresql)
         * with versionRef 'org.postgresql.postgresql'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getPostgresql() {
                return create("org.postgresql.postgresql");
        }

    }

    public static class OrgProjectlombokLibraryAccessors extends SubDependencyFactory {

        public OrgProjectlombokLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for lombok (org.projectlombok:lombok)
         * with versionRef 'org.projectlombok.lombok'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getLombok() {
                return create("org.projectlombok.lombok");
        }

    }

    public static class OrgSpringdocLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringdocSpringdocLibraryAccessors laccForOrgSpringdocSpringdocLibraryAccessors = new OrgSpringdocSpringdocLibraryAccessors(owner);

        public OrgSpringdocLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.springdoc.springdoc
         */
        public OrgSpringdocSpringdocLibraryAccessors getSpringdoc() {
            return laccForOrgSpringdocSpringdocLibraryAccessors;
        }

    }

    public static class OrgSpringdocSpringdocLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringdocSpringdocOpenapiLibraryAccessors laccForOrgSpringdocSpringdocOpenapiLibraryAccessors = new OrgSpringdocSpringdocOpenapiLibraryAccessors(owner);

        public OrgSpringdocSpringdocLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.springdoc.springdoc.openapi
         */
        public OrgSpringdocSpringdocOpenapiLibraryAccessors getOpenapi() {
            return laccForOrgSpringdocSpringdocOpenapiLibraryAccessors;
        }

    }

    public static class OrgSpringdocSpringdocOpenapiLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringdocSpringdocOpenapiStarterLibraryAccessors laccForOrgSpringdocSpringdocOpenapiStarterLibraryAccessors = new OrgSpringdocSpringdocOpenapiStarterLibraryAccessors(owner);

        public OrgSpringdocSpringdocOpenapiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for ui (org.springdoc:springdoc-openapi-ui)
         * with versionRef 'org.springdoc.springdoc.openapi.ui'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getUi() {
                return create("org.springdoc.springdoc.openapi.ui");
        }

        /**
         * Returns the group of libraries at org.springdoc.springdoc.openapi.starter
         */
        public OrgSpringdocSpringdocOpenapiStarterLibraryAccessors getStarter() {
            return laccForOrgSpringdocSpringdocOpenapiStarterLibraryAccessors;
        }

    }

    public static class OrgSpringdocSpringdocOpenapiStarterLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringdocSpringdocOpenapiStarterWebmvcLibraryAccessors laccForOrgSpringdocSpringdocOpenapiStarterWebmvcLibraryAccessors = new OrgSpringdocSpringdocOpenapiStarterWebmvcLibraryAccessors(owner);

        public OrgSpringdocSpringdocOpenapiStarterLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.springdoc.springdoc.openapi.starter.webmvc
         */
        public OrgSpringdocSpringdocOpenapiStarterWebmvcLibraryAccessors getWebmvc() {
            return laccForOrgSpringdocSpringdocOpenapiStarterWebmvcLibraryAccessors;
        }

    }

    public static class OrgSpringdocSpringdocOpenapiStarterWebmvcLibraryAccessors extends SubDependencyFactory {

        public OrgSpringdocSpringdocOpenapiStarterWebmvcLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for ui (org.springdoc:springdoc-openapi-starter-webmvc-ui)
         * with versionRef 'org.springdoc.springdoc.openapi.starter.webmvc.ui'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getUi() {
                return create("org.springdoc.springdoc.openapi.starter.webmvc.ui");
        }

    }

    public static class OrgSpringframeworkLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBatchLibraryAccessors laccForOrgSpringframeworkBatchLibraryAccessors = new OrgSpringframeworkBatchLibraryAccessors(owner);
        private final OrgSpringframeworkBootLibraryAccessors laccForOrgSpringframeworkBootLibraryAccessors = new OrgSpringframeworkBootLibraryAccessors(owner);
        private final OrgSpringframeworkSecurityLibraryAccessors laccForOrgSpringframeworkSecurityLibraryAccessors = new OrgSpringframeworkSecurityLibraryAccessors(owner);

        public OrgSpringframeworkLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.springframework.batch
         */
        public OrgSpringframeworkBatchLibraryAccessors getBatch() {
            return laccForOrgSpringframeworkBatchLibraryAccessors;
        }

        /**
         * Returns the group of libraries at org.springframework.boot
         */
        public OrgSpringframeworkBootLibraryAccessors getBoot() {
            return laccForOrgSpringframeworkBootLibraryAccessors;
        }

        /**
         * Returns the group of libraries at org.springframework.security
         */
        public OrgSpringframeworkSecurityLibraryAccessors getSecurity() {
            return laccForOrgSpringframeworkSecurityLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkBatchLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBatchSpringLibraryAccessors laccForOrgSpringframeworkBatchSpringLibraryAccessors = new OrgSpringframeworkBatchSpringLibraryAccessors(owner);

        public OrgSpringframeworkBatchLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.springframework.batch.spring
         */
        public OrgSpringframeworkBatchSpringLibraryAccessors getSpring() {
            return laccForOrgSpringframeworkBatchSpringLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkBatchSpringLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBatchSpringBatchLibraryAccessors laccForOrgSpringframeworkBatchSpringBatchLibraryAccessors = new OrgSpringframeworkBatchSpringBatchLibraryAccessors(owner);

        public OrgSpringframeworkBatchSpringLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.springframework.batch.spring.batch
         */
        public OrgSpringframeworkBatchSpringBatchLibraryAccessors getBatch() {
            return laccForOrgSpringframeworkBatchSpringBatchLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkBatchSpringBatchLibraryAccessors extends SubDependencyFactory {

        public OrgSpringframeworkBatchSpringBatchLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (org.springframework.batch:spring-batch-core)
         * with versionRef 'org.springframework.batch.spring.batch.core'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() {
                return create("org.springframework.batch.spring.batch.core");
        }

    }

    public static class OrgSpringframeworkBootLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBootSpringLibraryAccessors laccForOrgSpringframeworkBootSpringLibraryAccessors = new OrgSpringframeworkBootSpringLibraryAccessors(owner);

        public OrgSpringframeworkBootLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.springframework.boot.spring
         */
        public OrgSpringframeworkBootSpringLibraryAccessors getSpring() {
            return laccForOrgSpringframeworkBootSpringLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBootSpringBootLibraryAccessors laccForOrgSpringframeworkBootSpringBootLibraryAccessors = new OrgSpringframeworkBootSpringBootLibraryAccessors(owner);

        public OrgSpringframeworkBootSpringLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.springframework.boot.spring.boot
         */
        public OrgSpringframeworkBootSpringBootLibraryAccessors getBoot() {
            return laccForOrgSpringframeworkBootSpringBootLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBootSpringBootStarterLibraryAccessors laccForOrgSpringframeworkBootSpringBootStarterLibraryAccessors = new OrgSpringframeworkBootSpringBootStarterLibraryAccessors(owner);

        public OrgSpringframeworkBootSpringBootLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.springframework.boot.spring.boot.starter
         */
        public OrgSpringframeworkBootSpringBootStarterLibraryAccessors getStarter() {
            return laccForOrgSpringframeworkBootSpringBootStarterLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootStarterLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {
        private final OrgSpringframeworkBootSpringBootStarterDataLibraryAccessors laccForOrgSpringframeworkBootSpringBootStarterDataLibraryAccessors = new OrgSpringframeworkBootSpringBootStarterDataLibraryAccessors(owner);
        private final OrgSpringframeworkBootSpringBootStarterOauth2LibraryAccessors laccForOrgSpringframeworkBootSpringBootStarterOauth2LibraryAccessors = new OrgSpringframeworkBootSpringBootStarterOauth2LibraryAccessors(owner);

        public OrgSpringframeworkBootSpringBootStarterLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for starter (org.springframework.boot:spring-boot-starter)
         * with versionRef 'org.springframework.boot.spring.boot.starter'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() {
                return create("org.springframework.boot.spring.boot.starter");
        }

            /**
             * Creates a dependency provider for aop (org.springframework.boot:spring-boot-starter-aop)
         * with versionRef 'org.springframework.boot.spring.boot.starter.aop'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAop() {
                return create("org.springframework.boot.spring.boot.starter.aop");
        }

            /**
             * Creates a dependency provider for jdbc (org.springframework.boot:spring-boot-starter-jdbc)
         * with versionRef 'org.springframework.boot.spring.boot.starter.jdbc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJdbc() {
                return create("org.springframework.boot.spring.boot.starter.jdbc");
        }

            /**
             * Creates a dependency provider for thymeleaf (org.springframework.boot:spring-boot-starter-thymeleaf)
         * with versionRef 'org.springframework.boot.spring.boot.starter.thymeleaf'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getThymeleaf() {
                return create("org.springframework.boot.spring.boot.starter.thymeleaf");
        }

            /**
             * Creates a dependency provider for web (org.springframework.boot:spring-boot-starter-web)
         * with versionRef 'org.springframework.boot.spring.boot.starter.web'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getWeb() {
                return create("org.springframework.boot.spring.boot.starter.web");
        }

        /**
         * Returns the group of libraries at org.springframework.boot.spring.boot.starter.data
         */
        public OrgSpringframeworkBootSpringBootStarterDataLibraryAccessors getData() {
            return laccForOrgSpringframeworkBootSpringBootStarterDataLibraryAccessors;
        }

        /**
         * Returns the group of libraries at org.springframework.boot.spring.boot.starter.oauth2
         */
        public OrgSpringframeworkBootSpringBootStarterOauth2LibraryAccessors getOauth2() {
            return laccForOrgSpringframeworkBootSpringBootStarterOauth2LibraryAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootStarterDataLibraryAccessors extends SubDependencyFactory {

        public OrgSpringframeworkBootSpringBootStarterDataLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for redis (org.springframework.boot:spring-boot-starter-data-redis)
         * with versionRef 'org.springframework.boot.spring.boot.starter.data.redis'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getRedis() {
                return create("org.springframework.boot.spring.boot.starter.data.redis");
        }

    }

    public static class OrgSpringframeworkBootSpringBootStarterOauth2LibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBootSpringBootStarterOauth2ResourceLibraryAccessors laccForOrgSpringframeworkBootSpringBootStarterOauth2ResourceLibraryAccessors = new OrgSpringframeworkBootSpringBootStarterOauth2ResourceLibraryAccessors(owner);

        public OrgSpringframeworkBootSpringBootStarterOauth2LibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.springframework.boot.spring.boot.starter.oauth2.resource
         */
        public OrgSpringframeworkBootSpringBootStarterOauth2ResourceLibraryAccessors getResource() {
            return laccForOrgSpringframeworkBootSpringBootStarterOauth2ResourceLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootStarterOauth2ResourceLibraryAccessors extends SubDependencyFactory {

        public OrgSpringframeworkBootSpringBootStarterOauth2ResourceLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for server (org.springframework.boot:spring-boot-starter-oauth2-resource-server)
         * with versionRef 'org.springframework.boot.spring.boot.starter.oauth2.resource.server'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getServer() {
                return create("org.springframework.boot.spring.boot.starter.oauth2.resource.server");
        }

    }

    public static class OrgSpringframeworkSecurityLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkSecuritySpringLibraryAccessors laccForOrgSpringframeworkSecuritySpringLibraryAccessors = new OrgSpringframeworkSecuritySpringLibraryAccessors(owner);

        public OrgSpringframeworkSecurityLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.springframework.security.spring
         */
        public OrgSpringframeworkSecuritySpringLibraryAccessors getSpring() {
            return laccForOrgSpringframeworkSecuritySpringLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkSecuritySpringLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkSecuritySpringSecurityLibraryAccessors laccForOrgSpringframeworkSecuritySpringSecurityLibraryAccessors = new OrgSpringframeworkSecuritySpringSecurityLibraryAccessors(owner);

        public OrgSpringframeworkSecuritySpringLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.springframework.security.spring.security
         */
        public OrgSpringframeworkSecuritySpringSecurityLibraryAccessors getSecurity() {
            return laccForOrgSpringframeworkSecuritySpringSecurityLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkSecuritySpringSecurityLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkSecuritySpringSecurityOauth2LibraryAccessors laccForOrgSpringframeworkSecuritySpringSecurityOauth2LibraryAccessors = new OrgSpringframeworkSecuritySpringSecurityOauth2LibraryAccessors(owner);

        public OrgSpringframeworkSecuritySpringSecurityLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for config (org.springframework.security:spring-security-config)
         * with versionRef 'org.springframework.security.spring.security.config'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getConfig() {
                return create("org.springframework.security.spring.security.config");
        }

            /**
             * Creates a dependency provider for core (org.springframework.security:spring-security-core)
         * with versionRef 'org.springframework.security.spring.security.core'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() {
                return create("org.springframework.security.spring.security.core");
        }

        /**
         * Returns the group of libraries at org.springframework.security.spring.security.oauth2
         */
        public OrgSpringframeworkSecuritySpringSecurityOauth2LibraryAccessors getOauth2() {
            return laccForOrgSpringframeworkSecuritySpringSecurityOauth2LibraryAccessors;
        }

    }

    public static class OrgSpringframeworkSecuritySpringSecurityOauth2LibraryAccessors extends SubDependencyFactory {

        public OrgSpringframeworkSecuritySpringSecurityOauth2LibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for jose (org.springframework.security:spring-security-oauth2-jose)
         * with versionRef 'org.springframework.security.spring.security.oauth2.jose'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJose() {
                return create("org.springframework.security.spring.security.oauth2.jose");
        }

    }

    public static class VersionAccessors extends VersionFactory  {

        private final ComVersionAccessors vaccForComVersionAccessors = new ComVersionAccessors(providers, config);
        private final CommonsVersionAccessors vaccForCommonsVersionAccessors = new CommonsVersionAccessors(providers, config);
        private final IoVersionAccessors vaccForIoVersionAccessors = new IoVersionAccessors(providers, config);
        private final JavaxVersionAccessors vaccForJavaxVersionAccessors = new JavaxVersionAccessors(providers, config);
        private final OrgVersionAccessors vaccForOrgVersionAccessors = new OrgVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.com
         */
        public ComVersionAccessors getCom() {
            return vaccForComVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.commons
         */
        public CommonsVersionAccessors getCommons() {
            return vaccForCommonsVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.io
         */
        public IoVersionAccessors getIo() {
            return vaccForIoVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.javax
         */
        public JavaxVersionAccessors getJavax() {
            return vaccForJavaxVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.org
         */
        public OrgVersionAccessors getOrg() {
            return vaccForOrgVersionAccessors;
        }

    }

    public static class ComVersionAccessors extends VersionFactory  {

        private final ComFasterxmlVersionAccessors vaccForComFasterxmlVersionAccessors = new ComFasterxmlVersionAccessors(providers, config);
        private final ComGoogleVersionAccessors vaccForComGoogleVersionAccessors = new ComGoogleVersionAccessors(providers, config);
        private final ComGooglecodeVersionAccessors vaccForComGooglecodeVersionAccessors = new ComGooglecodeVersionAccessors(providers, config);
        public ComVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.com.fasterxml
         */
        public ComFasterxmlVersionAccessors getFasterxml() {
            return vaccForComFasterxmlVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.com.google
         */
        public ComGoogleVersionAccessors getGoogle() {
            return vaccForComGoogleVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.com.googlecode
         */
        public ComGooglecodeVersionAccessors getGooglecode() {
            return vaccForComGooglecodeVersionAccessors;
        }

    }

    public static class ComFasterxmlVersionAccessors extends VersionFactory  {

        private final ComFasterxmlJacksonVersionAccessors vaccForComFasterxmlJacksonVersionAccessors = new ComFasterxmlJacksonVersionAccessors(providers, config);
        public ComFasterxmlVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.com.fasterxml.jackson
         */
        public ComFasterxmlJacksonVersionAccessors getJackson() {
            return vaccForComFasterxmlJacksonVersionAccessors;
        }

    }

    public static class ComFasterxmlJacksonVersionAccessors extends VersionFactory  {

        private final ComFasterxmlJacksonCoreVersionAccessors vaccForComFasterxmlJacksonCoreVersionAccessors = new ComFasterxmlJacksonCoreVersionAccessors(providers, config);
        public ComFasterxmlJacksonVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.com.fasterxml.jackson.core
         */
        public ComFasterxmlJacksonCoreVersionAccessors getCore() {
            return vaccForComFasterxmlJacksonCoreVersionAccessors;
        }

    }

    public static class ComFasterxmlJacksonCoreVersionAccessors extends VersionFactory  {

        private final ComFasterxmlJacksonCoreJacksonVersionAccessors vaccForComFasterxmlJacksonCoreJacksonVersionAccessors = new ComFasterxmlJacksonCoreJacksonVersionAccessors(providers, config);
        public ComFasterxmlJacksonCoreVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.com.fasterxml.jackson.core.jackson
         */
        public ComFasterxmlJacksonCoreJacksonVersionAccessors getJackson() {
            return vaccForComFasterxmlJacksonCoreJacksonVersionAccessors;
        }

    }

    public static class ComFasterxmlJacksonCoreJacksonVersionAccessors extends VersionFactory  {

        public ComFasterxmlJacksonCoreJacksonVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: com.fasterxml.jackson.core.jackson.databind (2.15.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getDatabind() { return getVersion("com.fasterxml.jackson.core.jackson.databind"); }

    }

    public static class ComGoogleVersionAccessors extends VersionFactory  {

        private final ComGoogleCodeVersionAccessors$1 vaccForComGoogleCodeVersionAccessors$1 = new ComGoogleCodeVersionAccessors$1(providers, config);
        public ComGoogleVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.com.google.code
         */
        public ComGoogleCodeVersionAccessors$1 getCode() {
            return vaccForComGoogleCodeVersionAccessors$1;
        }

    }

    public static class ComGoogleCodeVersionAccessors$1 extends VersionFactory  {

        private final ComGoogleCodeGsonVersionAccessors vaccForComGoogleCodeGsonVersionAccessors = new ComGoogleCodeGsonVersionAccessors(providers, config);
        public ComGoogleCodeVersionAccessors$1(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.com.google.code.gson
         */
        public ComGoogleCodeGsonVersionAccessors getGson() {
            return vaccForComGoogleCodeGsonVersionAccessors;
        }

    }

    public static class ComGoogleCodeGsonVersionAccessors extends VersionFactory  {

        public ComGoogleCodeGsonVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: com.google.code.gson.gson (2.10.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getGson() { return getVersion("com.google.code.gson.gson"); }

    }

    public static class ComGooglecodeVersionAccessors extends VersionFactory  {

        private final ComGooglecodeJsonVersionAccessors vaccForComGooglecodeJsonVersionAccessors = new ComGooglecodeJsonVersionAccessors(providers, config);
        public ComGooglecodeVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.com.googlecode.json
         */
        public ComGooglecodeJsonVersionAccessors getJson() {
            return vaccForComGooglecodeJsonVersionAccessors;
        }

    }

    public static class ComGooglecodeJsonVersionAccessors extends VersionFactory  {

        private final ComGooglecodeJsonSimpleVersionAccessors vaccForComGooglecodeJsonSimpleVersionAccessors = new ComGooglecodeJsonSimpleVersionAccessors(providers, config);
        public ComGooglecodeJsonVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.com.googlecode.json.simple
         */
        public ComGooglecodeJsonSimpleVersionAccessors getSimple() {
            return vaccForComGooglecodeJsonSimpleVersionAccessors;
        }

    }

    public static class ComGooglecodeJsonSimpleVersionAccessors extends VersionFactory  {

        private final ComGooglecodeJsonSimpleJsonVersionAccessors vaccForComGooglecodeJsonSimpleJsonVersionAccessors = new ComGooglecodeJsonSimpleJsonVersionAccessors(providers, config);
        public ComGooglecodeJsonSimpleVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.com.googlecode.json.simple.json
         */
        public ComGooglecodeJsonSimpleJsonVersionAccessors getJson() {
            return vaccForComGooglecodeJsonSimpleJsonVersionAccessors;
        }

    }

    public static class ComGooglecodeJsonSimpleJsonVersionAccessors extends VersionFactory  {

        public ComGooglecodeJsonSimpleJsonVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: com.googlecode.json.simple.json.simple (1.1.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getSimple() { return getVersion("com.googlecode.json.simple.json.simple"); }

    }

    public static class CommonsVersionAccessors extends VersionFactory  {

        private final CommonsFileuploadVersionAccessors vaccForCommonsFileuploadVersionAccessors = new CommonsFileuploadVersionAccessors(providers, config);
        public CommonsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.commons.fileupload
         */
        public CommonsFileuploadVersionAccessors getFileupload() {
            return vaccForCommonsFileuploadVersionAccessors;
        }

    }

    public static class CommonsFileuploadVersionAccessors extends VersionFactory  {

        private final CommonsFileuploadCommonsVersionAccessors vaccForCommonsFileuploadCommonsVersionAccessors = new CommonsFileuploadCommonsVersionAccessors(providers, config);
        public CommonsFileuploadVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.commons.fileupload.commons
         */
        public CommonsFileuploadCommonsVersionAccessors getCommons() {
            return vaccForCommonsFileuploadCommonsVersionAccessors;
        }

    }

    public static class CommonsFileuploadCommonsVersionAccessors extends VersionFactory  {

        public CommonsFileuploadCommonsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: commons.fileupload.commons.fileupload (1.5)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getFileupload() { return getVersion("commons.fileupload.commons.fileupload"); }

    }

    public static class IoVersionAccessors extends VersionFactory  {

        private final IoJsonwebtokenVersionAccessors vaccForIoJsonwebtokenVersionAccessors = new IoJsonwebtokenVersionAccessors(providers, config);
        public IoVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.io.jsonwebtoken
         */
        public IoJsonwebtokenVersionAccessors getJsonwebtoken() {
            return vaccForIoJsonwebtokenVersionAccessors;
        }

    }

    public static class IoJsonwebtokenVersionAccessors extends VersionFactory  {

        private final IoJsonwebtokenJjwtVersionAccessors vaccForIoJsonwebtokenJjwtVersionAccessors = new IoJsonwebtokenJjwtVersionAccessors(providers, config);
        public IoJsonwebtokenVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.io.jsonwebtoken.jjwt
         */
        public IoJsonwebtokenJjwtVersionAccessors getJjwt() {
            return vaccForIoJsonwebtokenJjwtVersionAccessors;
        }

    }

    public static class IoJsonwebtokenJjwtVersionAccessors extends VersionFactory  {

        public IoJsonwebtokenJjwtVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: io.jsonwebtoken.jjwt.jackson (0.11.5)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJackson() { return getVersion("io.jsonwebtoken.jjwt.jackson"); }

    }

    public static class JavaxVersionAccessors extends VersionFactory  {

        private final JavaxServletVersionAccessors vaccForJavaxServletVersionAccessors = new JavaxServletVersionAccessors(providers, config);
        public JavaxVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.javax.servlet
         */
        public JavaxServletVersionAccessors getServlet() {
            return vaccForJavaxServletVersionAccessors;
        }

    }

    public static class JavaxServletVersionAccessors extends VersionFactory  {

        public JavaxServletVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: javax.servlet.jstl (1.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJstl() { return getVersion("javax.servlet.jstl"); }

    }

    public static class OrgVersionAccessors extends VersionFactory  {

        private final OrgApacheVersionAccessors vaccForOrgApacheVersionAccessors = new OrgApacheVersionAccessors(providers, config);
        private final OrgBgeeVersionAccessors vaccForOrgBgeeVersionAccessors = new OrgBgeeVersionAccessors(providers, config);
        private final OrgCodehausVersionAccessors vaccForOrgCodehausVersionAccessors = new OrgCodehausVersionAccessors(providers, config);
        private final OrgHibernateVersionAccessors vaccForOrgHibernateVersionAccessors = new OrgHibernateVersionAccessors(providers, config);
        private final OrgJsonVersionAccessors vaccForOrgJsonVersionAccessors = new OrgJsonVersionAccessors(providers, config);
        private final OrgModelmapperVersionAccessors vaccForOrgModelmapperVersionAccessors = new OrgModelmapperVersionAccessors(providers, config);
        private final OrgMybatisVersionAccessors vaccForOrgMybatisVersionAccessors = new OrgMybatisVersionAccessors(providers, config);
        private final OrgPostgresqlVersionAccessors vaccForOrgPostgresqlVersionAccessors = new OrgPostgresqlVersionAccessors(providers, config);
        private final OrgProjectlombokVersionAccessors vaccForOrgProjectlombokVersionAccessors = new OrgProjectlombokVersionAccessors(providers, config);
        private final OrgSpringdocVersionAccessors vaccForOrgSpringdocVersionAccessors = new OrgSpringdocVersionAccessors(providers, config);
        private final OrgSpringframeworkVersionAccessors vaccForOrgSpringframeworkVersionAccessors = new OrgSpringframeworkVersionAccessors(providers, config);
        public OrgVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.apache
         */
        public OrgApacheVersionAccessors getApache() {
            return vaccForOrgApacheVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.org.bgee
         */
        public OrgBgeeVersionAccessors getBgee() {
            return vaccForOrgBgeeVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.org.codehaus
         */
        public OrgCodehausVersionAccessors getCodehaus() {
            return vaccForOrgCodehausVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.org.hibernate
         */
        public OrgHibernateVersionAccessors getHibernate() {
            return vaccForOrgHibernateVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.org.json
         */
        public OrgJsonVersionAccessors getJson() {
            return vaccForOrgJsonVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.org.modelmapper
         */
        public OrgModelmapperVersionAccessors getModelmapper() {
            return vaccForOrgModelmapperVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.org.mybatis
         */
        public OrgMybatisVersionAccessors getMybatis() {
            return vaccForOrgMybatisVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.org.postgresql
         */
        public OrgPostgresqlVersionAccessors getPostgresql() {
            return vaccForOrgPostgresqlVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.org.projectlombok
         */
        public OrgProjectlombokVersionAccessors getProjectlombok() {
            return vaccForOrgProjectlombokVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.org.springdoc
         */
        public OrgSpringdocVersionAccessors getSpringdoc() {
            return vaccForOrgSpringdocVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.org.springframework
         */
        public OrgSpringframeworkVersionAccessors getSpringframework() {
            return vaccForOrgSpringframeworkVersionAccessors;
        }

    }

    public static class OrgApacheVersionAccessors extends VersionFactory  {

        private final OrgApacheCassandraVersionAccessors vaccForOrgApacheCassandraVersionAccessors = new OrgApacheCassandraVersionAccessors(providers, config);
        private final OrgApacheHttpcomponentsVersionAccessors vaccForOrgApacheHttpcomponentsVersionAccessors = new OrgApacheHttpcomponentsVersionAccessors(providers, config);
        public OrgApacheVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.apache.cassandra
         */
        public OrgApacheCassandraVersionAccessors getCassandra() {
            return vaccForOrgApacheCassandraVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.org.apache.httpcomponents
         */
        public OrgApacheHttpcomponentsVersionAccessors getHttpcomponents() {
            return vaccForOrgApacheHttpcomponentsVersionAccessors;
        }

    }

    public static class OrgApacheCassandraVersionAccessors extends VersionFactory  {

        private final OrgApacheCassandraCassandraVersionAccessors vaccForOrgApacheCassandraCassandraVersionAccessors = new OrgApacheCassandraCassandraVersionAccessors(providers, config);
        public OrgApacheCassandraVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.apache.cassandra.cassandra
         */
        public OrgApacheCassandraCassandraVersionAccessors getCassandra() {
            return vaccForOrgApacheCassandraCassandraVersionAccessors;
        }

    }

    public static class OrgApacheCassandraCassandraVersionAccessors extends VersionFactory  {

        public OrgApacheCassandraCassandraVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.apache.cassandra.cassandra.all (0.8.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getAll() { return getVersion("org.apache.cassandra.cassandra.all"); }

    }

    public static class OrgApacheHttpcomponentsVersionAccessors extends VersionFactory  {

        public OrgApacheHttpcomponentsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.apache.httpcomponents.httpmime (4.3.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getHttpmime() { return getVersion("org.apache.httpcomponents.httpmime"); }

    }

    public static class OrgBgeeVersionAccessors extends VersionFactory  {

        private final OrgBgeeLog4jdbcVersionAccessors vaccForOrgBgeeLog4jdbcVersionAccessors = new OrgBgeeLog4jdbcVersionAccessors(providers, config);
        public OrgBgeeVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.bgee.log4jdbc
         */
        public OrgBgeeLog4jdbcVersionAccessors getLog4jdbc() {
            return vaccForOrgBgeeLog4jdbcVersionAccessors;
        }

    }

    public static class OrgBgeeLog4jdbcVersionAccessors extends VersionFactory  {

        private final OrgBgeeLog4jdbcLog4j2VersionAccessors vaccForOrgBgeeLog4jdbcLog4j2VersionAccessors = new OrgBgeeLog4jdbcLog4j2VersionAccessors(providers, config);
        public OrgBgeeLog4jdbcVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.bgee.log4jdbc.log4j2
         */
        public OrgBgeeLog4jdbcLog4j2VersionAccessors getLog4j2() {
            return vaccForOrgBgeeLog4jdbcLog4j2VersionAccessors;
        }

    }

    public static class OrgBgeeLog4jdbcLog4j2VersionAccessors extends VersionFactory  {

        private final OrgBgeeLog4jdbcLog4j2Log4jdbcVersionAccessors vaccForOrgBgeeLog4jdbcLog4j2Log4jdbcVersionAccessors = new OrgBgeeLog4jdbcLog4j2Log4jdbcVersionAccessors(providers, config);
        public OrgBgeeLog4jdbcLog4j2VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.bgee.log4jdbc.log4j2.log4jdbc
         */
        public OrgBgeeLog4jdbcLog4j2Log4jdbcVersionAccessors getLog4jdbc() {
            return vaccForOrgBgeeLog4jdbcLog4j2Log4jdbcVersionAccessors;
        }

    }

    public static class OrgBgeeLog4jdbcLog4j2Log4jdbcVersionAccessors extends VersionFactory  {

        private final OrgBgeeLog4jdbcLog4j2Log4jdbcLog4j2VersionAccessors vaccForOrgBgeeLog4jdbcLog4j2Log4jdbcLog4j2VersionAccessors = new OrgBgeeLog4jdbcLog4j2Log4jdbcLog4j2VersionAccessors(providers, config);
        public OrgBgeeLog4jdbcLog4j2Log4jdbcVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.bgee.log4jdbc.log4j2.log4jdbc.log4j2
         */
        public OrgBgeeLog4jdbcLog4j2Log4jdbcLog4j2VersionAccessors getLog4j2() {
            return vaccForOrgBgeeLog4jdbcLog4j2Log4jdbcLog4j2VersionAccessors;
        }

    }

    public static class OrgBgeeLog4jdbcLog4j2Log4jdbcLog4j2VersionAccessors extends VersionFactory  {

        public OrgBgeeLog4jdbcLog4j2Log4jdbcLog4j2VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.bgee.log4jdbc.log4j2.log4jdbc.log4j2.jdbc4 (1.16)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJdbc4() { return getVersion("org.bgee.log4jdbc.log4j2.log4jdbc.log4j2.jdbc4"); }

    }

    public static class OrgCodehausVersionAccessors extends VersionFactory  {

        private final OrgCodehausJacksonVersionAccessors vaccForOrgCodehausJacksonVersionAccessors = new OrgCodehausJacksonVersionAccessors(providers, config);
        public OrgCodehausVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.codehaus.jackson
         */
        public OrgCodehausJacksonVersionAccessors getJackson() {
            return vaccForOrgCodehausJacksonVersionAccessors;
        }

    }

    public static class OrgCodehausJacksonVersionAccessors extends VersionFactory  {

        private final OrgCodehausJacksonJacksonVersionAccessors vaccForOrgCodehausJacksonJacksonVersionAccessors = new OrgCodehausJacksonJacksonVersionAccessors(providers, config);
        public OrgCodehausJacksonVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.codehaus.jackson.jackson
         */
        public OrgCodehausJacksonJacksonVersionAccessors getJackson() {
            return vaccForOrgCodehausJacksonJacksonVersionAccessors;
        }

    }

    public static class OrgCodehausJacksonJacksonVersionAccessors extends VersionFactory  {

        private final OrgCodehausJacksonJacksonMapperVersionAccessors vaccForOrgCodehausJacksonJacksonMapperVersionAccessors = new OrgCodehausJacksonJacksonMapperVersionAccessors(providers, config);
        public OrgCodehausJacksonJacksonVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.codehaus.jackson.jackson.mapper
         */
        public OrgCodehausJacksonJacksonMapperVersionAccessors getMapper() {
            return vaccForOrgCodehausJacksonJacksonMapperVersionAccessors;
        }

    }

    public static class OrgCodehausJacksonJacksonMapperVersionAccessors extends VersionFactory  {

        public OrgCodehausJacksonJacksonMapperVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.codehaus.jackson.jackson.mapper.asl (1.9.13)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getAsl() { return getVersion("org.codehaus.jackson.jackson.mapper.asl"); }

    }

    public static class OrgHibernateVersionAccessors extends VersionFactory  {

        private final OrgHibernateHibernateVersionAccessors vaccForOrgHibernateHibernateVersionAccessors = new OrgHibernateHibernateVersionAccessors(providers, config);
        public OrgHibernateVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.hibernate.hibernate
         */
        public OrgHibernateHibernateVersionAccessors getHibernate() {
            return vaccForOrgHibernateHibernateVersionAccessors;
        }

    }

    public static class OrgHibernateHibernateVersionAccessors extends VersionFactory  {

        public OrgHibernateHibernateVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.hibernate.hibernate.validator (8.0.1.Final)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getValidator() { return getVersion("org.hibernate.hibernate.validator"); }

    }

    public static class OrgJsonVersionAccessors extends VersionFactory  {

        public OrgJsonVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.json.json (20231013)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJson() { return getVersion("org.json.json"); }

    }

    public static class OrgModelmapperVersionAccessors extends VersionFactory  {

        public OrgModelmapperVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.modelmapper.modelmapper (3.1.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getModelmapper() { return getVersion("org.modelmapper.modelmapper"); }

    }

    public static class OrgMybatisVersionAccessors extends VersionFactory  {

        private final OrgMybatisSpringVersionAccessors vaccForOrgMybatisSpringVersionAccessors = new OrgMybatisSpringVersionAccessors(providers, config);
        public OrgMybatisVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.mybatis.spring
         */
        public OrgMybatisSpringVersionAccessors getSpring() {
            return vaccForOrgMybatisSpringVersionAccessors;
        }

    }

    public static class OrgMybatisSpringVersionAccessors extends VersionFactory  {

        private final OrgMybatisSpringBootVersionAccessors vaccForOrgMybatisSpringBootVersionAccessors = new OrgMybatisSpringBootVersionAccessors(providers, config);
        public OrgMybatisSpringVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.mybatis.spring.boot
         */
        public OrgMybatisSpringBootVersionAccessors getBoot() {
            return vaccForOrgMybatisSpringBootVersionAccessors;
        }

    }

    public static class OrgMybatisSpringBootVersionAccessors extends VersionFactory  {

        private final OrgMybatisSpringBootMybatisVersionAccessors vaccForOrgMybatisSpringBootMybatisVersionAccessors = new OrgMybatisSpringBootMybatisVersionAccessors(providers, config);
        public OrgMybatisSpringBootVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.mybatis.spring.boot.mybatis
         */
        public OrgMybatisSpringBootMybatisVersionAccessors getMybatis() {
            return vaccForOrgMybatisSpringBootMybatisVersionAccessors;
        }

    }

    public static class OrgMybatisSpringBootMybatisVersionAccessors extends VersionFactory  {

        private final OrgMybatisSpringBootMybatisSpringVersionAccessors vaccForOrgMybatisSpringBootMybatisSpringVersionAccessors = new OrgMybatisSpringBootMybatisSpringVersionAccessors(providers, config);
        public OrgMybatisSpringBootMybatisVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.mybatis.spring.boot.mybatis.spring
         */
        public OrgMybatisSpringBootMybatisSpringVersionAccessors getSpring() {
            return vaccForOrgMybatisSpringBootMybatisSpringVersionAccessors;
        }

    }

    public static class OrgMybatisSpringBootMybatisSpringVersionAccessors extends VersionFactory  {

        private final OrgMybatisSpringBootMybatisSpringBootVersionAccessors vaccForOrgMybatisSpringBootMybatisSpringBootVersionAccessors = new OrgMybatisSpringBootMybatisSpringBootVersionAccessors(providers, config);
        public OrgMybatisSpringBootMybatisSpringVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.mybatis.spring.boot.mybatis.spring.boot
         */
        public OrgMybatisSpringBootMybatisSpringBootVersionAccessors getBoot() {
            return vaccForOrgMybatisSpringBootMybatisSpringBootVersionAccessors;
        }

    }

    public static class OrgMybatisSpringBootMybatisSpringBootVersionAccessors extends VersionFactory  {

        public OrgMybatisSpringBootMybatisSpringBootVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.mybatis.spring.boot.mybatis.spring.boot.starter (3.0.3)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getStarter() { return getVersion("org.mybatis.spring.boot.mybatis.spring.boot.starter"); }

    }

    public static class OrgPostgresqlVersionAccessors extends VersionFactory  {

        public OrgPostgresqlVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.postgresql.postgresql (42.6.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getPostgresql() { return getVersion("org.postgresql.postgresql"); }

    }

    public static class OrgProjectlombokVersionAccessors extends VersionFactory  {

        public OrgProjectlombokVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.projectlombok.lombok (1.18.26)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getLombok() { return getVersion("org.projectlombok.lombok"); }

    }

    public static class OrgSpringdocVersionAccessors extends VersionFactory  {

        private final OrgSpringdocSpringdocVersionAccessors vaccForOrgSpringdocSpringdocVersionAccessors = new OrgSpringdocSpringdocVersionAccessors(providers, config);
        public OrgSpringdocVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.springdoc.springdoc
         */
        public OrgSpringdocSpringdocVersionAccessors getSpringdoc() {
            return vaccForOrgSpringdocSpringdocVersionAccessors;
        }

    }

    public static class OrgSpringdocSpringdocVersionAccessors extends VersionFactory  {

        private final OrgSpringdocSpringdocOpenapiVersionAccessors vaccForOrgSpringdocSpringdocOpenapiVersionAccessors = new OrgSpringdocSpringdocOpenapiVersionAccessors(providers, config);
        public OrgSpringdocSpringdocVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.springdoc.springdoc.openapi
         */
        public OrgSpringdocSpringdocOpenapiVersionAccessors getOpenapi() {
            return vaccForOrgSpringdocSpringdocOpenapiVersionAccessors;
        }

    }

    public static class OrgSpringdocSpringdocOpenapiVersionAccessors extends VersionFactory  {

        private final OrgSpringdocSpringdocOpenapiStarterVersionAccessors vaccForOrgSpringdocSpringdocOpenapiStarterVersionAccessors = new OrgSpringdocSpringdocOpenapiStarterVersionAccessors(providers, config);
        public OrgSpringdocSpringdocOpenapiVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.springdoc.springdoc.openapi.ui (1.7.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getUi() { return getVersion("org.springdoc.springdoc.openapi.ui"); }

        /**
         * Returns the group of versions at versions.org.springdoc.springdoc.openapi.starter
         */
        public OrgSpringdocSpringdocOpenapiStarterVersionAccessors getStarter() {
            return vaccForOrgSpringdocSpringdocOpenapiStarterVersionAccessors;
        }

    }

    public static class OrgSpringdocSpringdocOpenapiStarterVersionAccessors extends VersionFactory  {

        private final OrgSpringdocSpringdocOpenapiStarterWebmvcVersionAccessors vaccForOrgSpringdocSpringdocOpenapiStarterWebmvcVersionAccessors = new OrgSpringdocSpringdocOpenapiStarterWebmvcVersionAccessors(providers, config);
        public OrgSpringdocSpringdocOpenapiStarterVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.springdoc.springdoc.openapi.starter.webmvc
         */
        public OrgSpringdocSpringdocOpenapiStarterWebmvcVersionAccessors getWebmvc() {
            return vaccForOrgSpringdocSpringdocOpenapiStarterWebmvcVersionAccessors;
        }

    }

    public static class OrgSpringdocSpringdocOpenapiStarterWebmvcVersionAccessors extends VersionFactory  {

        public OrgSpringdocSpringdocOpenapiStarterWebmvcVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.springdoc.springdoc.openapi.starter.webmvc.ui (2.1.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getUi() { return getVersion("org.springdoc.springdoc.openapi.starter.webmvc.ui"); }

    }

    public static class OrgSpringframeworkVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkBatchVersionAccessors vaccForOrgSpringframeworkBatchVersionAccessors = new OrgSpringframeworkBatchVersionAccessors(providers, config);
        private final OrgSpringframeworkBootVersionAccessors vaccForOrgSpringframeworkBootVersionAccessors = new OrgSpringframeworkBootVersionAccessors(providers, config);
        private final OrgSpringframeworkSecurityVersionAccessors vaccForOrgSpringframeworkSecurityVersionAccessors = new OrgSpringframeworkSecurityVersionAccessors(providers, config);
        public OrgSpringframeworkVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.springframework.batch
         */
        public OrgSpringframeworkBatchVersionAccessors getBatch() {
            return vaccForOrgSpringframeworkBatchVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.org.springframework.boot
         */
        public OrgSpringframeworkBootVersionAccessors getBoot() {
            return vaccForOrgSpringframeworkBootVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.org.springframework.security
         */
        public OrgSpringframeworkSecurityVersionAccessors getSecurity() {
            return vaccForOrgSpringframeworkSecurityVersionAccessors;
        }

    }

    public static class OrgSpringframeworkBatchVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkBatchSpringVersionAccessors vaccForOrgSpringframeworkBatchSpringVersionAccessors = new OrgSpringframeworkBatchSpringVersionAccessors(providers, config);
        public OrgSpringframeworkBatchVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.springframework.batch.spring
         */
        public OrgSpringframeworkBatchSpringVersionAccessors getSpring() {
            return vaccForOrgSpringframeworkBatchSpringVersionAccessors;
        }

    }

    public static class OrgSpringframeworkBatchSpringVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkBatchSpringBatchVersionAccessors vaccForOrgSpringframeworkBatchSpringBatchVersionAccessors = new OrgSpringframeworkBatchSpringBatchVersionAccessors(providers, config);
        public OrgSpringframeworkBatchSpringVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.springframework.batch.spring.batch
         */
        public OrgSpringframeworkBatchSpringBatchVersionAccessors getBatch() {
            return vaccForOrgSpringframeworkBatchSpringBatchVersionAccessors;
        }

    }

    public static class OrgSpringframeworkBatchSpringBatchVersionAccessors extends VersionFactory  {

        public OrgSpringframeworkBatchSpringBatchVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.springframework.batch.spring.batch.core (5.0.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getCore() { return getVersion("org.springframework.batch.spring.batch.core"); }

    }

    public static class OrgSpringframeworkBootVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkBootSpringVersionAccessors vaccForOrgSpringframeworkBootSpringVersionAccessors = new OrgSpringframeworkBootSpringVersionAccessors(providers, config);
        public OrgSpringframeworkBootVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.springframework.boot.spring
         */
        public OrgSpringframeworkBootSpringVersionAccessors getSpring() {
            return vaccForOrgSpringframeworkBootSpringVersionAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkBootSpringBootVersionAccessors vaccForOrgSpringframeworkBootSpringBootVersionAccessors = new OrgSpringframeworkBootSpringBootVersionAccessors(providers, config);
        public OrgSpringframeworkBootSpringVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.springframework.boot.spring.boot
         */
        public OrgSpringframeworkBootSpringBootVersionAccessors getBoot() {
            return vaccForOrgSpringframeworkBootSpringBootVersionAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkBootSpringBootStarterVersionAccessors vaccForOrgSpringframeworkBootSpringBootStarterVersionAccessors = new OrgSpringframeworkBootSpringBootStarterVersionAccessors(providers, config);
        public OrgSpringframeworkBootSpringBootVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.springframework.boot.spring.boot.starter
         */
        public OrgSpringframeworkBootSpringBootStarterVersionAccessors getStarter() {
            return vaccForOrgSpringframeworkBootSpringBootStarterVersionAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootStarterVersionAccessors extends VersionFactory  implements VersionNotationSupplier {

        private final OrgSpringframeworkBootSpringBootStarterDataVersionAccessors vaccForOrgSpringframeworkBootSpringBootStarterDataVersionAccessors = new OrgSpringframeworkBootSpringBootStarterDataVersionAccessors(providers, config);
        private final OrgSpringframeworkBootSpringBootStarterOauth2VersionAccessors vaccForOrgSpringframeworkBootSpringBootStarterOauth2VersionAccessors = new OrgSpringframeworkBootSpringBootStarterOauth2VersionAccessors(providers, config);
        public OrgSpringframeworkBootSpringBootStarterVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the version associated to this alias: org.springframework.boot.spring.boot.starter (3.1.0)
         * If the version is a rich version and that its not expressible as a
         * single version string, then an empty string is returned.
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> asProvider() { return getVersion("org.springframework.boot.spring.boot.starter"); }

            /**
             * Returns the version associated to this alias: org.springframework.boot.spring.boot.starter.aop (2.4.4)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getAop() { return getVersion("org.springframework.boot.spring.boot.starter.aop"); }

            /**
             * Returns the version associated to this alias: org.springframework.boot.spring.boot.starter.jdbc (3.1.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJdbc() { return getVersion("org.springframework.boot.spring.boot.starter.jdbc"); }

            /**
             * Returns the version associated to this alias: org.springframework.boot.spring.boot.starter.thymeleaf (3.1.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getThymeleaf() { return getVersion("org.springframework.boot.spring.boot.starter.thymeleaf"); }

            /**
             * Returns the version associated to this alias: org.springframework.boot.spring.boot.starter.web (3.1.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getWeb() { return getVersion("org.springframework.boot.spring.boot.starter.web"); }

        /**
         * Returns the group of versions at versions.org.springframework.boot.spring.boot.starter.data
         */
        public OrgSpringframeworkBootSpringBootStarterDataVersionAccessors getData() {
            return vaccForOrgSpringframeworkBootSpringBootStarterDataVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.org.springframework.boot.spring.boot.starter.oauth2
         */
        public OrgSpringframeworkBootSpringBootStarterOauth2VersionAccessors getOauth2() {
            return vaccForOrgSpringframeworkBootSpringBootStarterOauth2VersionAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootStarterDataVersionAccessors extends VersionFactory  {

        public OrgSpringframeworkBootSpringBootStarterDataVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.springframework.boot.spring.boot.starter.data.redis (3.1.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getRedis() { return getVersion("org.springframework.boot.spring.boot.starter.data.redis"); }

    }

    public static class OrgSpringframeworkBootSpringBootStarterOauth2VersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkBootSpringBootStarterOauth2ResourceVersionAccessors vaccForOrgSpringframeworkBootSpringBootStarterOauth2ResourceVersionAccessors = new OrgSpringframeworkBootSpringBootStarterOauth2ResourceVersionAccessors(providers, config);
        public OrgSpringframeworkBootSpringBootStarterOauth2VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.springframework.boot.spring.boot.starter.oauth2.resource
         */
        public OrgSpringframeworkBootSpringBootStarterOauth2ResourceVersionAccessors getResource() {
            return vaccForOrgSpringframeworkBootSpringBootStarterOauth2ResourceVersionAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootStarterOauth2ResourceVersionAccessors extends VersionFactory  {

        public OrgSpringframeworkBootSpringBootStarterOauth2ResourceVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.springframework.boot.spring.boot.starter.oauth2.resource.server (3.1.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getServer() { return getVersion("org.springframework.boot.spring.boot.starter.oauth2.resource.server"); }

    }

    public static class OrgSpringframeworkSecurityVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkSecuritySpringVersionAccessors vaccForOrgSpringframeworkSecuritySpringVersionAccessors = new OrgSpringframeworkSecuritySpringVersionAccessors(providers, config);
        public OrgSpringframeworkSecurityVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.springframework.security.spring
         */
        public OrgSpringframeworkSecuritySpringVersionAccessors getSpring() {
            return vaccForOrgSpringframeworkSecuritySpringVersionAccessors;
        }

    }

    public static class OrgSpringframeworkSecuritySpringVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkSecuritySpringSecurityVersionAccessors vaccForOrgSpringframeworkSecuritySpringSecurityVersionAccessors = new OrgSpringframeworkSecuritySpringSecurityVersionAccessors(providers, config);
        public OrgSpringframeworkSecuritySpringVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.springframework.security.spring.security
         */
        public OrgSpringframeworkSecuritySpringSecurityVersionAccessors getSecurity() {
            return vaccForOrgSpringframeworkSecuritySpringSecurityVersionAccessors;
        }

    }

    public static class OrgSpringframeworkSecuritySpringSecurityVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkSecuritySpringSecurityOauth2VersionAccessors vaccForOrgSpringframeworkSecuritySpringSecurityOauth2VersionAccessors = new OrgSpringframeworkSecuritySpringSecurityOauth2VersionAccessors(providers, config);
        public OrgSpringframeworkSecuritySpringSecurityVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.springframework.security.spring.security.config (6.1.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getConfig() { return getVersion("org.springframework.security.spring.security.config"); }

            /**
             * Returns the version associated to this alias: org.springframework.security.spring.security.core (6.1.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getCore() { return getVersion("org.springframework.security.spring.security.core"); }

        /**
         * Returns the group of versions at versions.org.springframework.security.spring.security.oauth2
         */
        public OrgSpringframeworkSecuritySpringSecurityOauth2VersionAccessors getOauth2() {
            return vaccForOrgSpringframeworkSecuritySpringSecurityOauth2VersionAccessors;
        }

    }

    public static class OrgSpringframeworkSecuritySpringSecurityOauth2VersionAccessors extends VersionFactory  {

        public OrgSpringframeworkSecuritySpringSecurityOauth2VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.springframework.security.spring.security.oauth2.jose (6.1.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJose() { return getVersion("org.springframework.security.spring.security.oauth2.jose"); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

    }

    public static class PluginAccessors extends PluginFactory {

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

}
