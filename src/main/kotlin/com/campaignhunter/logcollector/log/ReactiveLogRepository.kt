package com.campaignhunter.logcollector.log

import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository
import org.springframework.stereotype.Repository

@Repository
interface ReactiveLogRepository: ReactiveElasticsearchRepository<Log, String> {
}