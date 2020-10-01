DROP TABLE IF EXISTS annotation_avps;
DROP TABLE IF EXISTS values;
DROP TABLE IF EXISTS attributes;
DROP TABLE IF EXISTS annotation_pos;
DROP TABLE IF EXISTS annotation;
CREATE TABLE annotation
(
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255),
  type VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);
CREATE TABLE annotation_pos
(
  annotation_id INT NOT NULL,
  chromosome_id INT NOT NULL,
  start INT NOT NULL,
  stop INT NOT NULL,
  UNIQUE (annotation_id, chromosome_id)
);
CREATE TABLE attributes
(
  id INT NOT NULL AUTO_INCREMENT,
  type VARCHAR(255) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE (type)
);
CREATE TABLE values
(
  id BIGINT NOT NULL AUTO_INCREMENT,
  value TEXT NOT NULL,
  sha1 CHAR(40) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE (sha1)
);
CREATE TABLE annotation_avps
(
  annotation_id BIGINT NOT NULL,
  attribute_id INT NOT NULL,
  value_id BIGINT NOT NULL,
  UNIQUE (annotation_id, attribute_id, value_id)
);

DROP TABLE IF EXISTS chromosomes;
CREATE TABLE chromosomes
(
  id INT NOT NULL AUTO_INCREMENT,
  map_id INT NOT NULL,
  length INT NOT NULL,
  name VARCHAR(16) NOT NULL,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS sources;
DROP TABLE IF EXISTS source_urls;
DROP TABLE IF EXISTS maps;
CREATE TABLE sources
(
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);
CREATE TABLE source_urls
(
  source_id INT NOT NULL,
  table ENUM('annotation', 'map', 'chromosome', 'home') NOT NULL,
  key VARCHAR(255) NOT NULL,
  url TEXT NOT NULL,
  UNIQUE (source_id, table)
);
CREATE TABLE maps
(
  id INT NOT NULL AUTO_INCREMENT,
  source_id INT NOT NULL,
  type ENUM('Genomic', 'Genetic', 'RH', 'Linkage', 'Cytoband') NOT NULL,
  species VARCHAR(255) NOT NULL,
  version VARCHAR(64) NOT NULL,
  loaded DATE NOT NULL DEFAULT CURDATE(),
  units ENUM('bp', 'cM', 'cR'),
  disabled BIT NOT NULL DEFAULT 0,
  PRIMARY KEY (id)
);


DROP TABLE IF EXISTS ontology_children;
DROP TABLE IF EXISTS ontology_node;
DROP TABLE IF EXISTS ontology_tree;
CREATE TABLE ontology_children
(
  node_id INT NOT NULL,
  child_id INT NOT NULL,
  UNIQUE (node_id, child_id)
);
CREATE TABLE ontology_node
(
  id INT NOT NULL AUTO_INCREMENT,
  tree_id INT NOT NULL,
  parent_node_id INT NOT NULL,
  category VARCHAR(255) NOT NULL,
  description TEXT,
  PRIMARY KEY (id)
);
CREATE TABLE ontology_tree
(
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  type VARCHAR(255) NOT NULL,
  version VARCHAR(64) NOT NULL,
  loaded DATE NOT NULL DEFAULT CURDATE(),
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS map2version;
DROP TABLE IF EXISTS versions;
CREATE TABLE map2version
(
  version_id INT NOT NULL,
  map_id INT NOT NULL,
  UNIQUE (version_id, map_id)
);
CREATE TABLE versions
(
  version INT NOT NULL,
  loaded DATE NOT NULL,
  expired DATE,
  UNIQUE (version)
);