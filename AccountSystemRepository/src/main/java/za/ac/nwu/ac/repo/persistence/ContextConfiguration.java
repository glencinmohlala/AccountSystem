package za.ac.nwu.ac.repo.persistence;

import za.ac.nwu.ac.repo.config.RepositoryTestConfig;

public @interface ContextConfiguration {
    Class<RepositoryTestConfig>[] classes();
}
