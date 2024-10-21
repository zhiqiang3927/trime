// SPDX-FileCopyrightText: 2015 - 2024 Rime community
//
// SPDX-License-Identifier: GPL-3.0-or-later

package com.osfans.trime.core

import kotlinx.coroutines.flow.SharedFlow

interface RimeApi {
    val callbackFlow: SharedFlow<RimeCallback>

    val stateFlow: SharedFlow<RimeLifecycle.State>

    val isReady: Boolean

    val schemaItemCached: SchemaItem

    val inputStatusCached: InputStatus

    suspend fun isEmpty(): Boolean

    suspend fun processKey(
        value: Int,
        modifiers: UInt = 0u,
    ): Boolean

    suspend fun processKey(
        value: KeyValue,
        modifiers: KeyModifiers,
    ): Boolean

    suspend fun selectCandidate(idx: Int): Boolean

    suspend fun forgetCandidate(idx: Int): Boolean

    suspend fun availableSchemata(): Array<SchemaItem>

    suspend fun enabledSchemata(): Array<SchemaItem>

    suspend fun setEnabledSchemata(schemaIds: Array<String>): Boolean

    suspend fun selectedSchemata(): Array<SchemaItem>

    suspend fun selectedSchemaId(): String

    suspend fun selectSchema(schemaId: String): Boolean

    suspend fun currentSchema(): SchemaItem

    suspend fun commitComposition(): Boolean

    suspend fun clearComposition()

    suspend fun setRuntimeOption(
        option: String,
        value: Boolean,
    )

    suspend fun getRuntimeOption(option: String): Boolean

    suspend fun getCandidates(
        startIndex: Int,
        limit: Int,
    ): Array<CandidateItem>
}
